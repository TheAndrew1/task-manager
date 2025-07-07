package org.taskManager.adapter.exceptionMapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.taskManager.adapter.dto.ErrorResponseDTO;
import org.taskManager.core.domain.exception.TaskTitleInvalidException;

@Provider
public class TaskTitleInvalidExceptionMapper implements ExceptionMapper<TaskTitleInvalidException> {
    @Override
    public Response toResponse(TaskTitleInvalidException exception) {
        ErrorResponseDTO error = new ErrorResponseDTO(exception.getMessage(), 400);

        return Response.status(Response.Status.BAD_REQUEST) // 400
                .entity(error)
                .build();
    }
}
