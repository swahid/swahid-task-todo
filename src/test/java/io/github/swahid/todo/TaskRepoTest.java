package io.github.swahid.todo;

import io.github.swahid.todo.entity.Priority;
import io.github.swahid.todo.entity.Status;
import io.github.swahid.todo.entity.Task;
import io.github.swahid.todo.repository.TaskRepo;
import io.github.swahid.todo.service.TaskService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TaskRepoTest {

    @Autowired
    TaskRepo taskRepo;

    @Test
    public void testCreateReadDelete() {
        Task task = new Task();
        task.setTaskId(1L);
        task.setTitle("Test title");
        task.setDescription("Test Description");
        task.setPriority(Priority.high);
        task.setStatus(Status.pending);
        task.setStartDate(new Date());
        task.setActive(true);
        task.setCreatedDate(new Date());

        taskRepo.save(task);

        Iterable<Task> taskList = taskRepo.findAll();
        Assertions.assertThat(taskList).extracting(Task::getTitle).contains("Test title");

        taskRepo.deleteAll();
        Assertions.assertThat(taskRepo.findAll()).isEmpty();
    }
}
