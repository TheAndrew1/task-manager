package org.taskManager.core.domain.exception;

public class TaskTitleInvalidException extends RuntimeException {
    public TaskTitleInvalidException() {
        super("Título da tarefa inválido!");
    }

    public TaskTitleInvalidException(String message) {
        super(message);
    }
}
