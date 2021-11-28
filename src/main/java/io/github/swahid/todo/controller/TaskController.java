
package io.github.swahid.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.swahid.todo.dto.ApiErrorResponse;
import io.github.swahid.todo.dto.ApiResponse;
import io.github.swahid.todo.service.TaskService;
import lombok.RequiredArgsConstructor;

/**
 * @author 'Saurav Wahid'<wahid.saurav@gmail.com>
 * @Since   Nov 28, 2021
 * @version 1.0.1
 */

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	

	@GetMapping
	public ResponseEntity<?> task(){
		
		try {
			return ResponseEntity
			        .status(HttpStatus.OK)
			        .body(new ApiResponse("success", "generate task list", taskService.findAll()));
		} catch (Exception e) {
			return ResponseEntity
			        .status(HttpStatus.INTERNAL_SERVER_ERROR)
			        .body(new ApiErrorResponse("failed", e.getMessage()));
		}
	}

}
