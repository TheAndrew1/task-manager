package org.taskManager.adapter.dto;

import lombok.Getter;
import lombok.Setter;
import org.taskManager.core.domain.model.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class TaskDTO {
    private UUID id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime creationDate;
    private LocalDateTime finishDate;

    public TaskDTO() {}

    public TaskDTO(UUID id, String title, String description, TaskStatus status, LocalDateTime creationDate, LocalDateTime finishDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.finishDate = finishDate;
    }
}