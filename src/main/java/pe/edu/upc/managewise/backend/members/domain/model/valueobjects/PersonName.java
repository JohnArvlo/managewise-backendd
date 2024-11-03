package pe.edu.upc.managewise.backend.members.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PersonName(String firstName, String lastName) {

    // Constructor que incluye validación
    public PersonName {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
    }

    // Método para obtener el nombre completo
    public String getFullName() {
        return String.join(", ", lastName, firstName);
    }
}
