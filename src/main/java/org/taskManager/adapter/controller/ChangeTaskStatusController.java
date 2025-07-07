package org.taskManager.adapter.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestQuery;
import org.taskManager.core.domain.model.TaskStatus;
import org.taskManager.core.usecase.ChangeTaskStatusUseCase;

import java.util.UUID;

@Path("/tasks")
public class ChangeTaskStatusController {
    @Inject
    private ChangeTaskStatusUseCase changeTaskStatusUseCase;

    @PUT
    @Path("/status")
    public Response changeTaskStatus(@RestQuery UUID id, @RestQuery TaskStatus taskStatus) {
        changeTaskStatusUseCase.changeTaskStatus(id, taskStatus);
        return Response.ok().build();
    }
}
