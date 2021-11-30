/**
 * PriorityService.java
 */
package io.github.swahid.todo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.swahid.todo.entity.Priority;
import io.github.swahid.todo.repository.PriorityRepo;

/**
 * @author  'Saurav Wahid'<wahid.saurav@gmail.com>
 * @since   Nov 26, 2021
 * @version 1.0.1
 */

@Service
public class PriorityService implements BaseService<Priority>{

	private final PriorityRepo priorityRepo;

	public PriorityService(PriorityRepo priorityRepo) {
		this.priorityRepo = priorityRepo;
	}

	@Override
	@Transactional(readOnly = true)
	public Priority findById(Integer id) throws Exception {
		return priorityRepo.getById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Priority> findAll() throws Exception {
		return priorityRepo.findAll();
	}

	@Override
	@Transactional
	public Priority save(Priority entity) throws Exception {
		entity.setActive(true);
		entity.setCreatedDate(new Date());
		entity.setUpdatedDate(new Date());
		priorityRepo.save(entity);
		return entity;
	}

	@Override
	@Transactional
	public Priority delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Priority priority = priorityRepo.getById(id);
		priorityRepo.delete(priority);
		return priority;
	}

	

}
