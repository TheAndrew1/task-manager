package org.taskManager.core.usecase;

import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.domain.model.TaskStatus;

import java.util.List;

public interface FindTasksByStatusUseCase {
    List<TaskModel> findTasksByStatus(TaskStatus status);
}
