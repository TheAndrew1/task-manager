package org.taskManager.application.implementation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.domain.repository.TaskRepository;
import org.taskManager.core.usecase.CreateTaskUseCase;

@ApplicationScoped
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    @Inject
    private TaskRepository taskRepository;

    @Override
    public void createTask(String title, String description) {
        TaskModel newTaskModel = new TaskModel(title, description);
        taskRepository.createTask(newTaskModel);
    }
}
