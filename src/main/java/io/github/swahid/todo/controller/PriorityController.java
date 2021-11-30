
package io.github.swahid.todo.controller;

import io.github.swahid.todo.dto.ApiErrorResponse;
import io.github.swahid.todo.dto.ApiResponse;
import io.github.swahid.todo.entity.Priority;
import io.github.swahid.todo.service.PriorityService;
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

@Api(value = "Priority Rest Controller", description = "REST API for priority")
@RestController
@RequestMapping("/api/v1/priority")
public class PriorityController {

	private final PriorityService priorityService;

	public PriorityController(PriorityService priorityService) {
		this.priorityService = priorityService;
	}

	@ApiOperation(value = "Get Priority ", response = Priority.class, tags = "getPriority")
	@GetMapping
	public ResponseEntity<?> priority(){
		try{
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ApiResponse("Success", "Priority data", priorityService.findAll()));
		}catch (Exception e){
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ApiErrorResponse("failed", e.getMessage()));
		}
	}

	@ApiOperation(value = "Priority save", response = Priority.class, tags = "savePriority")
	@PostMapping
	public ResponseEntity<?> priority(@RequestBody Priority priority){
		try{
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ApiResponse("Success", "insert successfully", priorityService.save(priority)));
		}catch (Exception e){
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ApiErrorResponse("failed", e.getMessage()));
		}
	}

}
