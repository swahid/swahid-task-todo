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
		return taskRepo.findAll(getSortBy("priorityValue"));
	}

	@Transactional(readOnly = true)
	public Object filter(Long taskId, String status, String priority) throws Exception {

		if (Objects.nonNull(taskId) && Objects.isNull(status) && Objects.isNull(priority)){
			return taskRepo.getById(taskId);
		}else if (Objects.isNull(taskId) && Objects.nonNull(status) && Objects.isNull(priority)){
			return taskRepo.findByStatus(Enum.valueOf(Status.class, status), getSortBy("priorityValue"));
		}else if (Objects.isNull(taskId) && Objects.isNull(status) && Objects.nonNull(priority)){
			return taskRepo.findByPriority(Enum.valueOf(Priority.class, priority), getSortBy("priorityValue"));
		}else{
			return findAll();
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

	private Sort getSortBy(String column){
		return Sort.by(Sort.Direction.DESC, column);
	}

	private Sort getSortBy(String... column){
		return Sort.by(Sort.Direction.DESC, column);
	}
}
