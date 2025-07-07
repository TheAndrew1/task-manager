package org.taskManager.core.domain.repository;

import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.domain.model.TaskStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository {
    Optional<TaskModel> findById(UUID id);

    List<TaskModel> findAllTasks();

    List<TaskModel> findByStatus(TaskStatus status);

    void createTask(TaskModel taskModel);

    void updateTask(TaskModel taskModel);

    void deleteTask(UUID id);
}
