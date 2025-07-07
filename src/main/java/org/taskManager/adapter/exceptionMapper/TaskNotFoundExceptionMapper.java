package org.taskManager.adapter.exceptionMapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.taskManager.adapter.dto.ErrorResponseDTO;
import org.taskManager.application.exception.TaskNotFoundException;

@Provider
public class TaskNotFoundExceptionMapper implements ExceptionMapper<TaskNotFoundException> {
    @Override
    public Response toResponse(TaskNotFoundException exception) {
        ErrorResponseDTO error = new ErrorResponseDTO(exception.getMessage(), 404);

        return Response.status(Response.Status.NOT_FOUND) // 400
                .entity(error)
                .build();
    }
}
