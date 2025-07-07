package org.taskManager.application.implementation;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.taskManager.application.exception.TaskNotFoundException;
import org.taskManager.core.domain.exception.TaskTitleInvalidException;
import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.domain.model.TaskStatus;
import org.taskManager.core.domain.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@QuarkusTest
public class EditTaskUseCaseImplTest {
    @InjectMock
    TaskRepository taskRepository;

    @Inject
    EditTaskUseCaseImpl editTaskUseCase;

    @Test
    @DisplayName("Deve atualizar o título e descrição da task")
    public void testEditTask() {
        UUID id = UUID.randomUUID();
        TaskModel dbTask = spy(new TaskModel(id, "Título", "Descrição", TaskStatus.PENDING, LocalDateTime.now(), null));

        when(taskRepository.findById(id)).thenReturn(Optional.of(dbTask));

        TaskModel updatedTask = new TaskModel(id, "Título Novo", "Descrição Nova", TaskStatus.PENDING, LocalDateTime.now(), null);

        editTaskUseCase.editTask(id, updatedTask);

        verify(dbTask).updateTitle("Título Novo");
        assertEquals(dbTask.getTitle(), updatedTask.getTitle());
        verify(dbTask).updateDescription("Descrição Nova");
        assertEquals(dbTask.getDescription(), updatedTask.getDescription());
        verify(taskRepository).updateTask(dbTask);
    }

    @Test
    @DisplayName("Deve atualizar o título da task")
    public void testEditTaskTitle() {
        UUID id = UUID.randomUUID();
        TaskModel dbTask = spy(new TaskModel(id, "Título", "Descrição", TaskStatus.PENDING, LocalDateTime.now(), null));

        when(taskRepository.findById(id)).thenReturn(Optional.of(dbTask));

        TaskModel updatedTask = new TaskModel(id, "Título Novo", "Descrição", TaskStatus.PENDING, LocalDateTime.now(), null);

        editTaskUseCase.editTask(id, updatedTask);

        verify(dbTask).updateTitle("Título Novo");
        assertEquals(dbTask.getTitle(), updatedTask.getTitle());
        verify(dbTask, never()).updateDescription(any());
        assertEquals(dbTask.getTitle(), updatedTask.getTitle());
        verify(taskRepository).updateTask(dbTask);
    }

    @Test
    @DisplayName("Deve atualizar a descrição da task")
    public void testEditTaskDescription() {
        UUID id = UUID.randomUUID();
        TaskModel dbTask = spy(new TaskModel(id, "Título", "Descrição", TaskStatus.PENDING, LocalDateTime.now(), null));

        when(taskRepository.findById(id)).thenReturn(Optional.of(dbTask));

        TaskModel updatedTask = new TaskModel(id, "Título", "Descrição Nova", TaskStatus.PENDING, LocalDateTime.now(), null);

        editTaskUseCase.editTask(id, updatedTask);

        verify(dbTask, never()).updateTitle(any());
        assertEquals(dbTask.getTitle(), updatedTask.getTitle());
        verify(dbTask).updateDescription("Descrição Nova");
        assertEquals(dbTask.getTitle(), updatedTask.getTitle());
        verify(taskRepository).updateTask(dbTask);
    }

    @Test
    @DisplayName("Deve lançar exception se a task não tiver título")
    public void testEditTaskWithoutTitle() {
        UUID id = UUID.randomUUID();
        TaskModel dbTask = spy(new TaskModel(id, "Título", "Descrição", TaskStatus.PENDING, LocalDateTime.now(), null));

        when(taskRepository.findById(id)).thenReturn(Optional.of(dbTask));

        TaskModel updatedTask = new TaskModel(id, "", "Descrição Nova", TaskStatus.PENDING, LocalDateTime.now(), null);

        assertThrows(TaskTitleInvalidException.class, () -> {
            editTaskUseCase.editTask(id, updatedTask);
        });
    }

    @Test
    @DisplayName("Deve lançar exception ao não encontrar task")
    public void testNotFindTaskById() {
        UUID id = UUID.randomUUID();
        TaskModel updatedTask = new TaskModel(id, "Título", "Descrição", TaskStatus.PENDING, LocalDateTime.now(), null);

        when(taskRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class, () -> {
            editTaskUseCase.editTask(id, updatedTask);
        });
    }
}
