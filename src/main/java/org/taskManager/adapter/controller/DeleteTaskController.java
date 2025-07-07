package org.taskManager.adapter.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestQuery;
import org.taskManager.core.usecase.DeleteTaskUseCase;

import java.util.UUID;

@Path("/tasks")
public class DeleteTaskController {
    @Inject
    private DeleteTaskUseCase deleteTaskUseCase;

    @DELETE
    public Response deleteTask(@RestQuery UUID id) {
        deleteTaskUseCase.deleteTask(id);
        return Response.ok().build();
    }
}
