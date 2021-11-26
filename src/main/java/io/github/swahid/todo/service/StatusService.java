/**
 * StatusService.java
 */
package io.github.swahid.todo.service;

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
		// TODO Auto-generated method stub
		return statusRepo.getById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Status> findAll() throws Exception {
		// TODO Auto-generated method stub
		return statusRepo.findAll();
	}

	@Override
	@Transactional
	public void save(Status entity) throws Exception {
		statusRepo.save(entity);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) throws Exception {
		statusRepo.delete(null);
		
	}

}
