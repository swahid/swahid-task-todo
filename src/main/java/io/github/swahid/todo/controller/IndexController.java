
package io.github.swahid.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 'Saurav Wahid'<wahid.saurav@gmail.com>
 * @Since   Nov 26, 2021
 * @version 1.0.1
 */

@RestController
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public ResponseEntity<?> index(){
		
		return ResponseEntity
                .status(HttpStatus.OK)
                .body("{'project': 'todolist task'}");
	}

}
