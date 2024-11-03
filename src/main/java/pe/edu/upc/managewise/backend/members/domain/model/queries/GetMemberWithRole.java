package pe.edu.upc.managewise.backend.members.domain.model.queries;

import pe.edu.upc.managewise.managewise_members.members.domain.model.valueobjects.PersonName;
import pe.edu.upc.managewise.managewise_members.members.domain.model.valueobjects.Role;

public record GetMemberWithRole(PersonName personName, Role role) {
}
