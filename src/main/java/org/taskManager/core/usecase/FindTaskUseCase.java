package org.taskManager.core.usecase;

import org.taskManager.core.domain.model.TaskModel;

import java.util.UUID;

public interface FindTaskUseCase {
    TaskModel findTaskById(UUID id);
}
