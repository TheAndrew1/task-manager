package org.taskManager.core.domain.model;

public enum TaskStatus {
    PENDING, IN_PROGRESS, COMPLETED;

    public boolean canBeCompleted() {
        return this != COMPLETED;
    }
}
