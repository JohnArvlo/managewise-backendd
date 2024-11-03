package pe.edu.upc.managewise.backend.meeting.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.edu.upc.managewise.backend.meeting.domain.model.commands.CreateMeetingCommand;
import pe.edu.upc.managewise.backend.meeting.domain.model.entities.Recording;
import pe.edu.upc.managewise.backend.meeting.domain.model.valueobjects.MeetingDate;
import pe.edu.upc.managewise.backend.meeting.domain.model.valueobjects.MeetingTime;
import pe.edu.upc.managewise.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "meetings")
public class Meeting extends AuditableAbstractAggregateRoot<Meeting> {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    @Getter
    @NotNull
    @NotBlank
    @Column(name = "title", length = 100, nullable = false)
    private String title;


    @Getter
    @Embedded
    private MeetingDate meetingDate;


    @Getter
    @Embedded
    private MeetingTime meetingTime;

    @Getter
    @NotNull
    @NotBlank
    @Column(name = "link", nullable = false)
    private String link;

    @Getter
    @Column(name = "access_code", length = 36, nullable = false, unique = true)
    private String accessCode = UUID.randomUUID().toString();

    @OneToMany(mappedBy = "meeting") // Aquí haces referencia a la propiedad 'meeting' en Recording
    private List<Recording> recordings;


    public List<Recording> getRecordings() {
        return recordings;
    }

    public void setRecordings(List<Recording> recordings) {
        this.recordings = recordings;
    }



    //---------------------------------------------------
    public Meeting(String title, String dateStr, String timeStr, String link, String participants) {
        this.title = title;
        this.meetingDate = MeetingDate.of(dateStr);
        this.meetingTime = MeetingTime.of(timeStr);
        this.link = link;
        this.accessCode = UUID.randomUUID().toString(); // Genera un UUID único
    }

    public Meeting(CreateMeetingCommand command) {
        this.title = command.title();
        this.meetingDate = MeetingDate.of(command.dateStr());
        this.meetingTime = MeetingTime.of(command.timeStr());
        this.link = command.link();
        this.accessCode = UUID.randomUUID().toString(); // Genera un UUID único
    }

    public Meeting() {
        this.accessCode = UUID.randomUUID().toString(); // Genera un UUID único por defecto
    }

    public void updateMeeting(String title, String dateStr, String timeStr, String link) {
        this.title = title;
        this.meetingDate = MeetingDate.of(dateStr);
        this.meetingTime = MeetingTime.of(timeStr);
        this.link = link;
        // El accessCode no cambia con updateMeeting()
    }

    public Recording getRecording(int index) {
        if (index >= 0 && index < recordings.size()) {
            return recordings.get(index);
        }
        return null; // o lanza una excepción si prefieres
    }
    //---------------------------------------------------


    // Getters
    public String getTitle() {
        return title;
    }

    public MeetingDate getMeetingDate() {
        return meetingDate;
    }

    public MeetingTime getMeetingTime() {
        return meetingTime;
    }

    public String getLink() {
        return link;
    }

    public String getAccessCode() {
        return accessCode;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setMeetingDate(MeetingDate meetingDate) {
        this.meetingDate = meetingDate;
    }

    public void setMeetingTime(MeetingTime meetingTime) {
        this.meetingTime = meetingTime;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

}


