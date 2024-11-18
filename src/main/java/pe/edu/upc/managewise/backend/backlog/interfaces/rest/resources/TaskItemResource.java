package pe.edu.upc.managewise.backend.backlog.interfaces.rest.resources;

public record TaskItemResource(Long taskId, String title, String description, Integer estimation) {
}
