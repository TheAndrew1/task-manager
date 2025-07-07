package org.taskManager.core.domain.exception;

public class TaskAlreadyCompletedException extends RuntimeException {
    public TaskAlreadyCompletedException() {
        super("A tarefa já foi concluída!");
    }

    public TaskAlreadyCompletedException(String message) {
        super(message);
    }
}