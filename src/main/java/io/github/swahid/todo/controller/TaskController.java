
package io.github.swahid.todo.controller;

import io.github.swahid.todo.dto.ApiErrorResponse;
import io.github.swahid.todo.dto.ApiResponse;
import io.github.swahid.todo.entity.Task;
import io.github.swahid.todo.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author 'Saurav Wahid'<wahid.saurav@gmail.com>
 * @Since   Nov 28, 2021
 * @version 1.0.1
 */
@Api(value = "task Rest Controller", description = "REST API for task")
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}


	@ApiOperation(value = "Get Task ", response = ResponseEntity.class, tags = "getTask")
	@GetMapping
	public ResponseEntity<?> task(@RequestParam(value = "taskId", required = false) Long taskId,
								  @RequestParam(value = "status", required = false) String status,
								  @RequestParam(value = "priority", required = false) String priority
								  ){
		
		try {
			return ResponseEntity
			        .status(HttpStatus.OK)
			        .body(new ApiResponse("success", "generate task list",
							taskService.filter(taskId, status, priority)));
		} catch (Exception e) {
			return ResponseEntity
			        .status(HttpStatus.INTERNAL_SERVER_ERROR)
			        .body(new ApiErrorResponse("failed", e.getMessage()));
		}
	}

	@ApiOperation(value = "Post Task ", response = ResponseEntity.class, tags = "saveTask")
	@PostMapping
	public ResponseEntity<?> task(@RequestBody Task task){
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ApiResponse("success", "generate task list",
							taskService.save(task)));
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiErrorResponse("failed", e.getMessage()));
		}
	}
	
	@ApiOperation(value = "Post Task ", response = ResponseEntity.class, tags = "saveTask")
	@DeleteMapping
	public ResponseEntity<?> task(@RequestParam(value = "taskId", required = true) Integer taskId ){
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ApiResponse("success", "generate task list",
							taskService.delete(taskId)));
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiErrorResponse("failed", e.getMessage()));
		}
	}

}
