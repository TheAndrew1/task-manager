package org.taskManager.infrastructure.persistence.mapper;

import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.infrastructure.persistence.entity.TaskEntity;

public class TaskMapper {
    public static TaskEntity toEntity(TaskModel taskModel) {
        return new TaskEntity(taskModel.getId(), taskModel.getTitle(), taskModel.getDescription(), taskModel.getStatus(), taskModel.getCreationDate(), taskModel.getFinishDate());
    }

    public static TaskModel toModel(TaskEntity taskEntity) {
        return new TaskModel(taskEntity.getId(), taskEntity.getTitle(), taskEntity.getDescription(), taskEntity.getStatus(), taskEntity.getCreationDate(), taskEntity.getFinishDate());
    }
}