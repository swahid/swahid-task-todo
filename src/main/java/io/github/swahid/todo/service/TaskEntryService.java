/**
 * TaskEntryService.java
 */
package io.github.swahid.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.swahid.todo.entity.TaskEntry;
import io.github.swahid.todo.repository.TaskEntryRepo;

/**
 * @author  'Saurav Wahid'<wahid.saurav@gmail.com>
 * @since   Nov 26, 2021
 * @version 1.0.1
 */

@Service
public class TaskEntryService implements BaseService<TaskEntry>{
	
	@Autowired
	private TaskEntryRepo taskEntryRepo;

	@Override
	public TaskEntry findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskEntry> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TaskEntry entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
