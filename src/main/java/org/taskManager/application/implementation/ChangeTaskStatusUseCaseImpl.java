package org.taskManager.application.implementation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.taskManager.application.exception.TaskNotFoundException;
import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.domain.model.TaskStatus;
import org.taskManager.core.domain.repository.TaskRepository;
import org.taskManager.core.usecase.ChangeTaskStatusUseCase;

import java.util.UUID;

@ApplicationScoped
public class ChangeTaskStatusUseCaseImpl implements ChangeTaskStatusUseCase {
    @Inject
    private TaskRepository taskRepository;

    @Override
    public void changeTaskStatus(UUID id, TaskStatus newStatus) {
        TaskModel taskModel = taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
        taskModel.changeStatus(newStatus);
        taskRepository.updateTask(taskModel);
    }
}
