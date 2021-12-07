package io.github.swahid.todo;

import io.github.swahid.todo.entity.Priority;
import io.github.swahid.todo.entity.Status;
import io.github.swahid.todo.entity.Task;
import io.github.swahid.todo.repository.TaskRepo;
import io.github.swahid.todo.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTests {

    @InjectMocks
    TaskService taskService;

    @Mock
    TaskRepo taskRepo;

    @Test
    public void findAllTask(){
        List<Task> list = new ArrayList<>();
        Task task = new Task();
        task.setTaskId(1L);
        task.setTitle("Test title");
        task.setDescription("Test Description");
        task.setPriority(Priority.high);
        task.setStatus(Status.pending);
        task.setStartDate(new Date());
        task.setActive(true);
        task.setCreatedDate(new Date());
        list.add(task);

        when(taskRepo.findAll()).thenReturn(list);

        List<Task> taskList = taskRepo.findAll();

        assertEquals(1, taskList.size());
        verify(taskRepo, times(1)).findAll();
    }

    @Test
    public void testCreateOrSaveEmployee() throws Exception {
        Task task = new Task();
        task.setTaskId(1L);
        task.setTitle("Test title");
        task.setDescription("Test Description");
        task.setPriority(Priority.high);
        task.setStatus(Status.pending);
        task.setStartDate(new Date());
        task.setActive(true);
        task.setCreatedDate(new Date());

        taskService.save(task);

        verify(taskRepo, times(1)).save(task);
    }

}
