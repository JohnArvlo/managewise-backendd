package pe.edu.upc.managewise.backend.meeting.domain.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecordingDTO {
    private Long id;
    private Long meetingId;
    private String meetingTitle; // Para mostrar el título de la reunión asociada
    private String recordingLink;
    private String duration;
    private boolean publicAccess;



    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }

    public String getRecordingLink() {
        return recordingLink;
    }

    public void setRecordingLink(String recordingLink) {
        this.recordingLink = recordingLink;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isPublicAccess() {
        return publicAccess;
    }

    public void setPublicAccess(boolean publicAccess) {
        this.publicAccess = publicAccess;
    }
}
