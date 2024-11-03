package pe.edu.upc.managewise.backend.members.interfaces.rest.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.edu.upc.managewise.managewise_members.members.application.internal.queryservices.MemberService;
import pe.edu.upc.managewise.managewise_members.members.domain.model.queries.GetMemberWithRole;
import pe.edu.upc.managewise.managewise_members.members.domain.model.aggregates.Member; // Asegúrate de tener esta clase

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping(value = "/api/v1/statistic/members", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Members", description = "Member Management Endpoints")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Método para obtener todos los miembros
    @GetMapping
    public ResponseEntity<List<GetMemberWithRole>> getAllMembers() {
        List<GetMemberWithRole> membersWithRoles = memberService.getAllMembers(); // Llama al servicio
        return new ResponseEntity<>(membersWithRoles, HttpStatus.OK); // Retorna los miembros con rol
    }

    // Método para crear un nuevo miembro
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        // Lógica para guardar el miembro
        Member savedMember = memberService.saveMember(member); // Asumiendo que tienes un método en el servicio para guardar
        return new ResponseEntity<>(savedMember, HttpStatus.CREATED); // Retorna el miembro guardado
    }
}
