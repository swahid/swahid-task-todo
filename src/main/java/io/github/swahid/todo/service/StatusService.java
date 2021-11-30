/**
 * StatusService.java
 */
package io.github.swahid.todo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.swahid.todo.entity.Status;
import io.github.swahid.todo.repository.StatusRepo;

/**
 * @author  'Saurav Wahid'<wahid.saurav@gmail.com>
 * @since   Nov 26, 2021
 * @version 1.0.1
 */

@Service
public class StatusService implements BaseService<Status>{
	
	@Autowired
	private StatusRepo statusRepo;

	@Override
	@Transactional(readOnly = true)
	public Status findById(Integer id) throws Exception {
		return statusRepo.getById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Status> findAll() throws Exception {
		return statusRepo.findAll();
	}

	@Override
	@Transactional
	public Status save(Status entity) throws Exception {
		entity.setActive(true);
		entity.setCreatedDate(new Date());
		entity.setUpdatedDate(new Date());
		statusRepo.save(entity);
		return  entity;
	}

	@Override
	@Transactional
	public Status delete(Integer id) throws Exception {
		Status status = statusRepo.getById(id);
		statusRepo.delete(null);
		return status;
	}

}
