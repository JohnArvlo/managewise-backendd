package pe.edu.upc.managewise.backend.members.interfaces.rest.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.edu.upc.managewise.managewise_members.members.application.internal.queryservices.UserStoryService;
import pe.edu.upc.managewise.managewise_members.members.domain.model.aggregates.UserStory;
import pe.edu.upc.managewise.managewise_members.members.domain.model.queries.GetUserStoryWithStatusWithEffort;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping(value = "/api/v1/statistic/user-stories", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "User Stories", description = "User Story Management Endpoints")
public class UserStoryController {

    private final UserStoryService userStoryService;

    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    // Método para obtener todas las User Stories
    @GetMapping
    public ResponseEntity<List<GetUserStoryWithStatusWithEffort>> getAllUserStories() {
        List<GetUserStoryWithStatusWithEffort> userStories = userStoryService.getAllUserStories();
        return new ResponseEntity<>(userStories, HttpStatus.OK);
    }

    // Método para crear User Stories
    @PostMapping
    public ResponseEntity<List<UserStory>> createUserStories(@RequestBody List<UserStory> userStories) {
        if (userStories == null || userStories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Retorna un error si la lista está vacía
        }

        List<UserStory> savedUserStories = userStories.stream()
                .map(userStoryService::saveUserStory) // Guardar cada User Story
                .collect(Collectors.toList());

        return new ResponseEntity<>(savedUserStories, HttpStatus.CREATED); // Retorna la lista de User Stories guardadas
    }
}
