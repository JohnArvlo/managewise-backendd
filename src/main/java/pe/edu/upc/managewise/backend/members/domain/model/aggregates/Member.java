package pe.edu.upc.managewise.backend.members.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.managewise.managewise_members.members.domain.model.valueobjects.PersonName;
import pe.edu.upc.managewise.managewise_members.members.domain.model.valueobjects.Role;
import pe.edu.upc.managewise.managewise_members.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Table(name = "members")
public class Member extends AuditableAbstractAggregateRoot<Member> {

    @Getter
    @Embedded
    private final PersonName personName;

    @Embedded
    private Role role;

    // Constructor sin parámetros
    public Member() {
        this.personName = null; // Asigna un valor por defecto o deja null
        this.role = null;       // Asigna un valor por defecto o deja null
    }

    // Constructor que no permite crear un Member sin un PersonName válido
    public Member(PersonName personName, Role role) {
        if (personName == null) {
            throw new IllegalArgumentException("PersonName cannot be null");
        }
        this.personName = personName;
        this.role = role; // Asume que el role puede ser null en algunos casos
    }

    // Método opcional para crear un Member con rol
    public Member(PersonName personName) {
        this(personName, null); // Asigna el rol como null si no se proporciona
    }

    public Role getRole() {
        return role;
    }
}
