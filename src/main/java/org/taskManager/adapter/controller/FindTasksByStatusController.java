package org.taskManager.adapter.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestQuery;
import org.taskManager.adapter.mapper.TaskMapper;
import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.domain.model.TaskStatus;
import org.taskManager.core.usecase.FindTasksByStatusUseCase;

import java.util.List;
import java.util.stream.Collectors;

@Path("/tasks")
public class FindTasksByStatusController {
    @Inject
    private FindTasksByStatusUseCase findTasksByStatusUseCase;

    @GET
    @Path("/status")
    public Response findTasksByStatus(@RestQuery TaskStatus taskStatus) {
        List<TaskModel> tasks = findTasksByStatusUseCase.findTasksByStatus(taskStatus);
        return Response.ok(
                tasks.stream().map(TaskMapper::toDTO).collect(Collectors.toList())
        ).build();
    }
}
