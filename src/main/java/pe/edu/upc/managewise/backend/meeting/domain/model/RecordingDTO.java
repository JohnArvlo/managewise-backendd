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

    // Getters
    public Long getId() {
        return id;
    }

    public Long getMeetingId() {
        return meetingId;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public String getRecordingLink() {
        return recordingLink;
    }

    public String getDuration() {
        return duration;
    }

    public boolean isPublicAccess() {
        return publicAccess;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public void setRecordingLink(String recordingLink) {
        this.recordingLink = recordingLink;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setPublicAccess(boolean publicAccess) {
        this.publicAccess = publicAccess;
    }
}
