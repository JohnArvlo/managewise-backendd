package pe.edu.upc.managewise.backend.meeting.domain.services;


import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.meeting.domain.model.commands.CreateRecordingCommand;
import pe.edu.upc.center.platform.meeting.domain.model.commands.DeleteRecordingCommand;

public interface RecordingCommandService {
    Long handle(CreateRecordingCommand command);
    void handle(DeleteRecordingCommand command);
}


