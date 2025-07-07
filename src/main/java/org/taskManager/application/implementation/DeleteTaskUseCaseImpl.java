package org.taskManager.application.implementation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.taskManager.core.domain.repository.TaskRepository;
import org.taskManager.core.usecase.DeleteTaskUseCase;

import java.util.UUID;

@ApplicationScoped
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {
    @Inject
    private TaskRepository taskRepository;

    @Override
    public void deleteTask(UUID id) {
        taskRepository.deleteTask(id);
    }
}
