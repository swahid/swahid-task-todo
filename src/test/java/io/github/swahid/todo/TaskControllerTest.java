package io.github.swahid.todo;

import io.github.swahid.todo.controller.TaskController;
import io.github.swahid.todo.entity.Priority;
import io.github.swahid.todo.entity.Status;
import io.github.swahid.todo.entity.Task;
import io.github.swahid.todo.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @MockBean
    TaskService taskService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testFindAll() throws Exception {
        Task task = new Task();
        task.setTaskId(1L);
        task.setTitle("Test title");
        task.setDescription("Test Description");
        task.setPriority(Priority.high);
        task.setStatus(Status.pending);
        task.setStartDate(new Date());
        task.setActive(true);
        task.setCreatedDate(new Date());

        List<Task> taskList = Arrays.asList(task);
        Mockito.when(taskService.findAll()).thenReturn(taskList);

        mockMvc.perform(get("/api/v1/task?"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"status\":\"success\",\"message\":\"generate task list\",\"data\":null}"));

    }
}
