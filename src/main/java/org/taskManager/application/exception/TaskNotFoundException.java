package org.taskManager.application.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException() {
        super("Tarefa não encontrada!");
    }

    public TaskNotFoundException(String message) {
        super(message);
    }
}