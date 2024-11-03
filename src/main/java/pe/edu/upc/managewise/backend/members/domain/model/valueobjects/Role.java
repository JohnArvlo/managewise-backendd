package pe.edu.upc.managewise.backend.members.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Role {

    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "role", nullable = false, length = 50)
    private String role;

    // Constructor por defecto
    public Role() {
        // Inicializa con valores por defecto si es necesario
    }

    public Role(Long roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    // Getters
    public Long getRoleId() {
        return roleId;
    }

    public String getRole() {
        return role;
    }
}
