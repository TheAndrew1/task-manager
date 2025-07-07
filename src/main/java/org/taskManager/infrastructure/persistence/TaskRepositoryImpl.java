package org.taskManager.infrastructure.persistence;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.taskManager.application.exception.TaskNotFoundException;
import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.domain.model.TaskStatus;
import org.taskManager.core.domain.repository.TaskRepository;
import org.taskManager.infrastructure.persistence.entity.TaskEntity;
import org.taskManager.infrastructure.persistence.mapper.TaskMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class TaskRepositoryImpl implements TaskRepository,PanacheRepository<TaskEntity> {
    @Override
    public Optional<TaskModel> findById(UUID id) {
        return find("id", id)
                .firstResultOptional()
                .map(TaskMapper::toModel);
    }

    @Override
    public List<TaskModel> findAllTasks() {
        return findAll()
                .list()
                .stream()
                .map(TaskMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskModel> findByStatus(TaskStatus status) {
        return find("status", status)
                .list()
                .stream()
                .map(TaskMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void createTask(TaskModel taskModel) {
        persist(TaskMapper.toEntity(taskModel));
    }

    @Override
    public void updateTask(TaskModel taskModel) {
        getEntityManager().merge(TaskMapper.toEntity(taskModel));
    }

    @Override
    public void deleteTask(UUID id) {
        TaskEntity taskEntity = find("id", id).firstResult();
        if(taskEntity != null) {
            delete(taskEntity);
        } else {
            throw new TaskNotFoundException();
        }

    }
}
