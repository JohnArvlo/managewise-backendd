package pe.edu.upc.managewise.backend.backlog.interfaces.rest.transform;

import pe.edu.upc.managewise.backend.backlog.domain.model.commands.UpdateUserStoryCommand;
import pe.edu.upc.managewise.backend.backlog.interfaces.rest.resources.UserStoryResource;

public class UpdateUserStoryCommandFromResourceAssembler {
    public static UpdateUserStoryCommand toCommandFromResource(Long id, UserStoryResource resource){
        return new UpdateUserStoryCommand(id, resource.title(), resource.description());
    }
}