package org.taskManager.adapter.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.taskManager.adapter.mapper.TaskMapper;
import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.usecase.FindAllTasksUseCase;

import java.util.List;
import java.util.stream.Collectors;

@Path("/tasks")
public class FindAllTasksController {
    @Inject
    private FindAllTasksUseCase findAllTasksUseCase;

    @GET
    @Path("/find-all")
    public Response findAllTasks() {
        List<TaskModel> tasks = findAllTasksUseCase.findAllTasks();
        return Response.ok(
                tasks.stream().map(TaskMapper::toDTO).collect(Collectors.toList())
        ).build();
    }
}
