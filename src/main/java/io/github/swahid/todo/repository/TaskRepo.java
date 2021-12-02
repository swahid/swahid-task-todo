/**
 * TaskEntryRepo.java
 */
package io.github.swahid.todo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import io.github.swahid.todo.entity.Task;

/**
 * @author  'Saurav Wahid'<wahid.saurav@gmail.com>
 * @since   Nov 26, 2021
 * @version 1.0.1
 */
public interface TaskRepo extends JpaRepository<Task, Serializable>{

    List<Task> findByStatus(String status, Sort sort);
    List<Task> findByPriority(String priority, Sort sort);
    List<Task> findByStatusAndPriority(String status, String priority, Sort sort);

}
