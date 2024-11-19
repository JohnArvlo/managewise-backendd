package pe.edu.upc.managewise.backend.issues.interfaces.rest.resources;

public record CreateIssueResource(
        String title,
        int sprintAssociate,
        String description,
        String status,
        String priority,
        String assignedTo,
        String madeBy,
        String createdIn,
        String resolutionDate
) {}