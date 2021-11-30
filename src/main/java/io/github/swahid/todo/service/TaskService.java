/**
 * TaskEntryService.java
 */
package io.github.swahid.todo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.swahid.todo.entity.Task;
import io.github.swahid.todo.repository.TaskRepo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author  'Saurav Wahid'<wahid.saurav@gmail.com>
 * @since   Nov 26, 2021
 * @version 1.0.1
 */

@Service
public class TaskService implements BaseService<Task>{
	
	@Autowired
	private TaskRepo taskRepo;

	@Override
	@Transactional(readOnly = true)
	public Task findById(Integer id) throws Exception {
		return taskRepo.getById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Task> findAll() throws Exception {
		return taskRepo.findAll();
	}

	@Override
	@Transactional
	public Task save(Task entity) throws Exception {
		taskRepo.save(entity);
		return entity;
	}

	@Override
	@Transactional
	public Task delete(Integer id) throws Exception {
		Optional<Task> taskOption = taskRepo.findById(id);
		if (taskOption.isPresent()) {
			taskRepo.delete(taskOption.get());
			return taskOption.get();
		}else {
			throw new EntityNotFoundException("no task found");
		}
		
	}

}
