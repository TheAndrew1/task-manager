package org.taskManager.adapter.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.taskManager.adapter.dto.TaskDTO;
import org.taskManager.core.usecase.CreateTaskUseCase;

@Path("/tasks")
public class CreateTaskController {
    @Inject
    private CreateTaskUseCase createTaskUseCase;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTask(TaskDTO taskDTO) {
        createTaskUseCase.createTask(taskDTO.getTitle(), taskDTO.getDescription());
        return Response.ok().build();
    }
}
