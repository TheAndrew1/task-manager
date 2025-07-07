package org.taskManager.application.implementation;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.taskManager.application.exception.TaskNotFoundException;
import org.taskManager.core.domain.model.TaskModel;
import org.taskManager.core.domain.model.TaskStatus;
import org.taskManager.core.domain.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@QuarkusTest
public class FindTaskUseCaseImplTest {
    @InjectMock
    TaskRepository taskRepository;

    @Inject
    FindTaskUseCaseImpl findTaskUseCase;

    @Test
    @DisplayName("Deve retornar a task quando encontrada")
    public void testFindTaskById() {
        UUID id = UUID.randomUUID();
        TaskModel expectedTask = new TaskModel(id, "Título", "Descrição", TaskStatus.PENDING, LocalDateTime.now(), null);

        when(taskRepository.findById(id)).thenReturn(Optional.of(expectedTask));

        TaskModel result = findTaskUseCase.findTaskById(id);

        assertNotNull(result);
        assertEquals(expectedTask.getId(), result.getId());
        assertEquals(expectedTask.getTitle(), result.getTitle());
        assertEquals(expectedTask.getDescription(), result.getDescription());
        assertEquals(expectedTask.getStatus(), result.getStatus());
        assertEquals(expectedTask.getCreationDate(), result.getCreationDate());
        assertEquals(expectedTask.getFinishDate(), result.getFinishDate());
    }

    @Test
    @DisplayName("Deve lançar exception ao não encontrar task")
    public void testNotFindTaskById() {
        UUID id = UUID.randomUUID();

        when(taskRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class, () -> {
            findTaskUseCase.findTaskById(id);
        });
    }
}
