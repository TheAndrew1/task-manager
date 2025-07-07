package org.taskManager.core.usecase;

import org.taskManager.core.domain.model.TaskModel;

import java.util.UUID;

public interface EditTaskUseCase {
    void editTask(UUID id, TaskModel taskModel);
}
