package org.taskManager.application.implementation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.taskManager.application.exception.TaskNotFoundException;
import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.domain.repository.TaskRepository;
import org.taskManager.core.usecase.FindTaskUseCase;

import java.util.UUID;

@ApplicationScoped
public class FindTaskUseCaseImpl implements FindTaskUseCase {
    @Inject
    private TaskRepository taskRepository;

    @Override
    public TaskModel findTaskById(UUID id) {
        return taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
    }
}