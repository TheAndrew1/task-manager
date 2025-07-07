package org.taskManager.core.usecase;

import org.taskManager.core.domain.model.TaskStatus;

import java.util.UUID;

public interface ChangeTaskStatusUseCase {
    void changeTaskStatus(UUID id, TaskStatus newStatus);
}
