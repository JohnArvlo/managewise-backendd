package pe.edu.upc.managewise.backend.members.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.managewise.managewise_members.members.domain.model.valueobjects.StatusHU;
import pe.edu.upc.managewise.managewise_members.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDate;

@Entity
@Table(name = "user_stories")
public class UserStory extends AuditableAbstractAggregateRoot<UserStory> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id; // ID del User Story

    @Column(nullable = false)
    private String title; // Título del User Story

    @Column(nullable = false)
    private String description; // Descripción del User Story

    @Column(nullable = false)
    private int effort; // Valor que representa el esfuerzo

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusHU status; // Estado del User Story

    @Column(nullable = false)
    private String startDate; // Fecha de inicio como String

    @Column(nullable = false)
    private String endDate; // Fecha de fin como String

    @Column(name = "sprint_id") // Asegúrate de que el nombre de la columna sea correcto
    private Long sprintId; // ID del Sprint asociado

    // Constructor por defecto
    public UserStory() {}

    // Constructor que permite crear un User Story
    public UserStory(String title, String description, int effort, StatusHU status, String startDate, String endDate, Long sprintId) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        if (effort < 0) {
            throw new IllegalArgumentException("Effort cannot be negative");
        }
        this.title = title;
        this.description = description;
        this.effort = effort;
        this.status = status;
        this.startDate = startDate; // Asignar como String
        this.endDate = endDate; // Asignar como String
        this.sprintId = sprintId; // Asignar sprintId
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getEffort() {
        return effort;
    }

    public StatusHU getStatus() {
        return status;
    }

    public String getStartDate() { // Cambiado a String
        return startDate;
    }

    public String getEndDate() { // Cambiado a String
        return endDate;
    }

    public Long getSprintId() { // Método actualizado
        return sprintId; // Retornar el ID del Sprint asociado
    }
}
