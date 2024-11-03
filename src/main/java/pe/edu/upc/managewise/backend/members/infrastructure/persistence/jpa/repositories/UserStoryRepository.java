package pe.edu.upc.managewise.backend.members.infrastructure.persistence.jpa.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.managewise.managewise_members.members.domain.model.aggregates.UserStory; // Asegúrate de importar la clase Sprint

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, Long> {

    // Puedes agregar métodos personalizados si es necesario
    List<UserStory> findAll();



    // Otros métodos adicionales, si los necesitas
}
