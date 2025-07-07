package org.taskManager.application.implementation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.domain.model.TaskStatus;
import org.taskManager.core.domain.repository.TaskRepository;
import org.taskManager.core.usecase.FindTasksByStatusUseCase;

import java.util.List;

@ApplicationScoped
public class FindTasksByStatusUseCaseImpl implements FindTasksByStatusUseCase {
    @Inject
    private TaskRepository taskRepository;

    @Override
    public List<TaskModel> findTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }
}
