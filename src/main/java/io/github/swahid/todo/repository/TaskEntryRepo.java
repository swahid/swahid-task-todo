/**
 * TaskEntryRepo.java
 */
package io.github.swahid.todo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.swahid.todo.entity.TaskEntry;

/**
 * @author  'Saurav Wahid'<wahid.saurav@gmail.com>
 * @since   Nov 26, 2021
 * @version 1.0.1
 */
public interface TaskEntryRepo extends JpaRepository<TaskEntry, Serializable>{

}
