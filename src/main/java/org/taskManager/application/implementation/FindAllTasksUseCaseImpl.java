package org.taskManager.application.implementation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.domain.repository.TaskRepository;
import org.taskManager.core.usecase.FindAllTasksUseCase;

import java.util.List;

@ApplicationScoped
public class FindAllTasksUseCaseImpl implements FindAllTasksUseCase {
    @Inject
    private TaskRepository taskRepository;

    @Override
    public List<TaskModel> findAllTasks() {
        return taskRepository.findAllTasks();
    }
}
