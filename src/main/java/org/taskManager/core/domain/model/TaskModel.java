package org.taskManager.core.domain.model;

import org.taskManager.core.domain.exception.TaskAlreadyCompletedException;
import org.taskManager.core.domain.exception.TaskTitleInvalidException;

import java.time.LocalDateTime;
import java.util.UUID;

public class TaskModel {
    private final UUID id;
    private String title;
    private String description;
    private TaskStatus status;
    private final LocalDateTime creationDate;
    private LocalDateTime finishDate;

    public TaskModel(String title, String description) {
        this.id = UUID.randomUUID();
        this.description = description;
        this.status = TaskStatus.PENDING;
        this.creationDate = LocalDateTime.now();
        updateTitle(title);
    }

    public TaskModel(UUID id, String title, String description, TaskStatus status, LocalDateTime creationDate, LocalDateTime finishDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.finishDate = finishDate;
    }

    public void updateTitle(String newTitle) {
        if(newTitle == null || newTitle.isBlank()) {
            throw new TaskTitleInvalidException();
        }
        this.title = newTitle;
    }

    public void updateDescription(String newDescription) {
        this.description = newDescription;
    }

    public void changeStatus(TaskStatus newStatus) {
        if(newStatus.equals(TaskStatus.COMPLETED)) {
            if(!this.status.canBeCompleted()) {
                throw new TaskAlreadyCompletedException();
            }
            this.finishDate = LocalDateTime.now();
        } else {
            finishDate = null;
        }
        this.status = newStatus;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }
}