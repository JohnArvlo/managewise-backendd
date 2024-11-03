package pe.edu.upc.managewise.backend.members.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.managewise.managewise_members.members.domain.model.aggregates.Member;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // Puedes agregar métodos personalizados si es necesario
    List<Member> findAll();

    // Otros métodos adicionales, si los necesitas
}
