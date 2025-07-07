package org.taskManager.adapter.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestQuery;
import org.taskManager.adapter.dto.TaskDTO;
import org.taskManager.adapter.mapper.TaskMapper;
import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.usecase.EditTaskUseCase;

import java.util.UUID;

@Path("/tasks")
public class EditTaskController {
    @Inject
    private EditTaskUseCase editTaskUseCase;
    @Inject
    private TaskMapper taskMapper;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/edit")
    public Response editTask(@RestQuery UUID id, TaskDTO taskDTO) {
        TaskModel taskModel = taskMapper.toModel(taskDTO);
        editTaskUseCase.editTask(id, taskModel);
        return Response.ok().build();
    }
}
