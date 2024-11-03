package pe.edu.upc.managewise.backend.members.domain.model.queries;

import pe.edu.upc.managewise.managewise_members.members.domain.model.valueobjects.StatusHU;

public record GetUserStoryWithStatusWithEffort(
        Long id, // ID del User Story
        String title, // Título del User Story
        String description, // Descripción del User Story
        StatusHU status, // Estado del User Story
        int effort, // Valor que representa el esfuerzo
        String startDate, // Fecha de inicio como String
        String endDate, // Fecha de fin como String
        Long sprintId // ID del Sprint asociado
) {
    // Puedes añadir aquí métodos adicionales si es necesario
}
