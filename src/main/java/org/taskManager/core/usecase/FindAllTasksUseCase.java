package org.taskManager.core.usecase;

import org.taskManager.core.domain.model.TaskModel;

import java.util.List;

public interface FindAllTasksUseCase {
    List<TaskModel> findAllTasks();
}
