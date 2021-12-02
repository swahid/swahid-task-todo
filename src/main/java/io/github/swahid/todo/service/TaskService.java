/**
 * TaskEntryService.java
 */
package io.github.swahid.todo.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import io.github.swahid.todo.entity.Priority;
import io.github.swahid.todo.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	public Task findById(Long id) throws Exception {
		return taskRepo.getById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Task> findAll() throws Exception {

		return taskRepo.findAll(Sort.by(Sort.Direction.DESC, "priorityValue"));
	}

	@Transactional(readOnly = true)
	public Object filter(Long taskId, String status, String priority) throws Exception {

		if (Objects.nonNull(taskId)){
			return taskRepo.getById(taskId);
		}else if (Objects.nonNull(status)){
			return taskRepo.findByStatus(Enum.valueOf(Status.class, status), Sort.by(Sort.Direction.DESC, "priorityValue"));
		}else if (Objects.nonNull(priority)){
			return taskRepo.findByPriority(Enum.valueOf(Priority.class, priority), Sort.by(Sort.Direction.DESC, "priorityValue"));
		}else{
			return taskRepo.findAll(Sort.by(Sort.Direction.DESC, "priorityValue"));
		}
	}

	@Override
	@Transactional
	public Task save(Task entity) throws Exception {

		if (Objects.isNull(entity.getTaskId())){
			entity.setActive(true);
			entity.setCreatedDate(new Date());
			entity.setUpdatedDate(new Date());
		}else{
			entity.setUpdatedDate(new Date());
		}
		taskRepo.save(entity);
		return entity;
	}

	@Override
	@Transactional
	public Task delete(Long id) throws Exception {
		Optional<Task> taskOption = taskRepo.findById(id);
		if (taskOption.isPresent()) {
			taskRepo.delete(taskOption.get());
			return taskOption.get();
		}else {
			throw new EntityNotFoundException("no task found");
		}
	}
}
