package pe.edu.upc.managewise.backend.members.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.managewise.managewise_members.members.domain.model.aggregates.Member;
import pe.edu.upc.managewise.managewise_members.members.domain.model.queries.GetAllMembersQuery;
import pe.edu.upc.managewise.managewise_members.members.domain.model.queries.GetMemberWithRole;
import pe.edu.upc.managewise.managewise_members.members.infrastructure.persistence.jpa.repositories.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Método para obtener todos los miembros
    public List<GetMemberWithRole> getAllMembers() {
        GetAllMembersQuery query = new GetAllMembersQuery(); // Crear el query
        return handle(query); // Llamar al manejador
    }

    // Método para guardar un nuevo miembro
    public Member saveMember(Member member) {
        return memberRepository.save(member); // Guardar el miembro y retornar el miembro guardado
    }

    private List<GetMemberWithRole> handle(GetAllMembersQuery query) {
        List<Member> members = memberRepository.findAll(); // Obtener todos los miembros

        // Mapear los miembros a GetMemberWithRole
        return members.stream()
                .map(member -> new GetMemberWithRole(
                        member.getPersonName(), // Suponiendo que member.getPersonName() devuelve un tipo compatible
                        member.getRole()        // Suponiendo que member.getRole() devuelve un tipo compatible
                ))
                .collect(Collectors.toList());
    }
}
