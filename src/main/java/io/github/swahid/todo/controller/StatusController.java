
package io.github.swahid.todo.controller;

import io.github.swahid.todo.dto.ApiErrorResponse;
import io.github.swahid.todo.dto.ApiResponse;
import io.github.swahid.todo.service.StatusService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.github.swahid.todo.entity.Status;
import io.swagger.annotations.ApiOperation;

/**
 * @author 'Saurav Wahid'<wahid.saurav@gmail.com>
 * @Since   Nov 28, 2021
 * @version 1.0.1
 */
@Api(value = "Status Rest Controller", description = "REST API for Tatus")
@RestController
@RequestMapping("/api/v1/status")
public class StatusController {

	private final StatusService statusService;

	public StatusController(StatusService statusService) {
		this.statusService = statusService;
	}


	@ApiOperation(value = "Get Status ", response = Status.class, tags = "getStatus")
	@GetMapping
	public ResponseEntity<?> status(){
		
		try{
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ApiResponse("Success", "fetch status", statusService.findAll()));
		}catch (Exception e){
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiErrorResponse("Failed", e.getMessage()));
		}

	}

	@ApiOperation(value = "save status ", response = Status.class, tags = "saveStatus")
	@PostMapping
	public ResponseEntity<?> status(@RequestBody Status status){

		try{
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ApiResponse("Success", "fetch status", statusService.save(status)));
		}catch (Exception e){
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiErrorResponse("Failed", e.getMessage()));
		}
	}
}
