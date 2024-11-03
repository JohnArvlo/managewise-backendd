package pe.edu.upc.managewise.backend.members.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.managewise.managewise_members.members.domain.model.aggregates.UserStory;
import pe.edu.upc.managewise.managewise_members.members.domain.model.queries.GetAllUserStoriesQuery;
import pe.edu.upc.managewise.managewise_members.members.domain.model.queries.GetUserStoryWithStatusWithEffort;
import pe.edu.upc.managewise.managewise_members.members.infrastructure.persistence.jpa.repositories.UserStoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserStoryService {
    private final UserStoryRepository userStoryRepository;

    public UserStoryService(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    public UserStory saveUserStory(UserStory userStory) {
        return userStoryRepository.save(userStory); // Guardar y retornar la User Story
    }


    // Método para obtener todas las User Stories
    public List<GetUserStoryWithStatusWithEffort> getAllUserStories() {
        GetAllUserStoriesQuery query = new GetAllUserStoriesQuery(); // Crear el query
        return handleGetAllUserStories(query); // Llamar al manejador
    }

    private List<GetUserStoryWithStatusWithEffort> handleGetAllUserStories(GetAllUserStoriesQuery query) {
        List<UserStory> userStories = userStoryRepository.findAll(); // Obtener todas las User Stories

        // Mapear las User Stories a GetUserStoryWithStatusWithEffort
        return userStories.stream()
                .map(userStory -> new GetUserStoryWithStatusWithEffort(
                        userStory.getId(), // ID de User Story
                        userStory.getTitle(), // Título de User Story
                        userStory.getDescription(), // Descripción de User Story
                        userStory.getStatus(), // Estado de User Story
                        userStory.getEffort(), // Esfuerzo de User Story
                        userStory.getStartDate(), // Ahora es String
                        userStory.getEndDate(), // Ahora es String
                        userStory.getSprintId() // Añadir sprintId
                ))
                .collect(Collectors.toList()); // Retornar la lista de User Stories
    }


}
