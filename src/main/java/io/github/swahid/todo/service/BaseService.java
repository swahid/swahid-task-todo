/**
 * BaseService.java
 */
package io.github.swahid.todo.service;

import java.util.List;

/**
 * @author  'Saurav Wahid'<wahid.saurav@gmail.com>
 * @since   Nov 26, 2021
 * @version 1.0.1
 * @param <T>
 */
public interface BaseService<T> {

	public T findById(Integer id) throws Exception;
	
	public List<T> findAll() throws Exception;
	
	public void save(T entity) throws Exception;
	
	public void delete(Integer id) throws Exception;
	
}
