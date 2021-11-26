/**
 * PriorityService.java
 */
package io.github.swahid.todo.service;

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
	
	@Autowired
	private PriorityRepo priorityRepo;

	@Override
	@Transactional(readOnly = true)
	public Priority findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return priorityRepo.getById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Priority> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void save(Priority entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
