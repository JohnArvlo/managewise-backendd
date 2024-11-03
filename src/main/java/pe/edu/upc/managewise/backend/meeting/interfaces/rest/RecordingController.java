package pe.edu.upc.managewise.backend.meeting.interfaces.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.center.platform.meeting.domain.model.RecordingDTO;
import pe.edu.upc.center.platform.meeting.domain.model.aggregates.Meeting; // Asegúrate de importar Meeting desde el paquete correcto
import pe.edu.upc.center.platform.meeting.domain.model.commands.CreateRecordingCommand;
import pe.edu.upc.center.platform.meeting.domain.model.queries.GetMeetingByTitleQuery;
import pe.edu.upc.center.platform.meeting.domain.services.MeetingQueryService; // Importar el servicio de consulta
import pe.edu.upc.center.platform.meeting.domain.services.RecordingCommandService;
import pe.edu.upc.center.platform.meeting.domain.services.RecordingService;
import  pe.edu.upc.center.platform.meeting.domain.model.queries.GetMeetingByIdQuery;
import pe.edu.upc.center.platform.meeting.interfaces.rest.transform.RecordingTransformer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import pe.edu.upc.center.platform.meeting.domain.model.commands.DeleteRecordingCommand;

@RestController
@RequestMapping("/api/recordings")
public class RecordingController {

    @Autowired
    private RecordingCommandService recordingCommandService; // Cambiado a RecordingCommandService

    @Autowired
    private RecordingService recordingService;

    @Autowired
    private RecordingTransformer recordingTransformer;

    @Autowired
    private MeetingQueryService meetingQueryService;

    @GetMapping
    public List<RecordingDTO> getAllRecordings() {
        return recordingService.getAllRecordings().stream()
                .map(recordingTransformer::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/meeting/{meetingId}")
    public List<RecordingDTO> getRecordingsByMeetingId(@PathVariable Long meetingId) {
        Optional<Meeting> meetingOptional = meetingQueryService.handle(new GetMeetingByIdQuery(meetingId));
        if (meetingOptional.isPresent()) {
            Meeting meeting = meetingOptional.get();
            return recordingService.getRecordingsByMeeting(meeting).stream()
                    .map(recordingTransformer::toDTO)
                    .collect(Collectors.toList());
        }
        return List.of(); // Devuelve una lista vacía si no se encuentra la reunión
    }

    @GetMapping("/meeting/name/{meetingTitle}")
    public List<RecordingDTO> getRecordingsByMeetingTitle(@PathVariable String meetingTitle) {

        Optional<Meeting> meetings = meetingQueryService.handle(new GetMeetingByTitleQuery(meetingTitle));
        if (!meetings.isEmpty()) {
            return meetings.stream()
                    .flatMap(meeting -> recordingService.getRecordingsByMeeting(meeting).stream())
                    .map(recordingTransformer::toDTO)
                    .collect(Collectors.toList());
        }
        return List.of(); // Devuelve una lista vacía si no se encuentran reuniones
    }

    @PostMapping
    public ResponseEntity<Long> createRecording(@RequestBody CreateRecordingCommand command) {
        Long recordingId = recordingCommandService.handle(command);
        return ResponseEntity.ok(recordingId); // Devuelve el ID de la grabación creada
    }

    @DeleteMapping("/{recordingId}")
    public ResponseEntity<Void> deleteRecording(@PathVariable Long recordingId) {
        recordingCommandService.handle(new DeleteRecordingCommand(recordingId));
        return ResponseEntity.noContent().build(); // Devuelve 204 No Content
    }


}