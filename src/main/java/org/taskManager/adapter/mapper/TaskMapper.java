package org.taskManager.adapter.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.taskManager.adapter.dto.TaskDTO;
import org.taskManager.core.domain.model.TaskModel;

@ApplicationScoped
public class TaskMapper {
    public static TaskDTO toDTO(TaskModel taskModel) {
        return new TaskDTO(taskModel.getId(), taskModel.getTitle(), taskModel.getDescription(), taskModel.getStatus(), taskModel.getCreationDate(), taskModel.getFinishDate());
    }

    public TaskModel toModel(TaskDTO taskDTO) {
        return new TaskModel(taskDTO.getId(), taskDTO.getTitle(), taskDTO.getDescription(), taskDTO.getStatus(), taskDTO.getCreationDate(), taskDTO.getFinishDate());
    }
}