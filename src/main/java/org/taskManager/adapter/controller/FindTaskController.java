package org.taskManager.adapter.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestQuery;
import org.taskManager.adapter.mapper.TaskMapper;
import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.usecase.FindTaskUseCase;

import java.util.UUID;

@Path("/tasks")
public class FindTaskController {
    @Inject
    private FindTaskUseCase findTaskUseCase;

    @GET
    @Path("/find")
    public Response findTaskById(@RestQuery UUID id) {
        TaskModel task = findTaskUseCase.findTaskById(id);
        return Response.ok(
            TaskMapper.toDTO(task)
        ).build();
    }
}
