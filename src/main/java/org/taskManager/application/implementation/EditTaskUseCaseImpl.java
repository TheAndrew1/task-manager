package org.taskManager.application.implementation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.taskManager.application.exception.TaskNotFoundException;
import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.domain.repository.TaskRepository;
import org.taskManager.core.usecase.EditTaskUseCase;

import java.util.UUID;

@ApplicationScoped
public class EditTaskUseCaseImpl implements EditTaskUseCase {
    @Inject
    private TaskRepository taskRepository;

    @Override
    public void editTask(UUID id, TaskModel updatedTaskModel) {
        TaskModel dbTaskModel = taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
        if(!updatedTaskModel.getTitle().equals(dbTaskModel.getTitle())) {
            dbTaskModel.updateTitle(updatedTaskModel.getTitle());
        }
        if(!updatedTaskModel.getDescription().equals(dbTaskModel.getDescription())) {
            dbTaskModel.updateDescription(updatedTaskModel.getDescription());
        }
        taskRepository.updateTask(dbTaskModel);
    }
}
