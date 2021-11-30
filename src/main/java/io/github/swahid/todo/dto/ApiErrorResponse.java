/**
 * ApiResponse.java
 */
package io.github.swahid.todo.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author  'Saurav Wahid'<wahid.saurav@gmail.com>
 * @since   Nov 26, 2021
 * @version 1.0.1
 */

@Data
@Getter
@Setter
public class ApiErrorResponse implements Serializable{

	private static final long serialVersionUID = 7728648260641053902L;
	
	private String  status;
	private String  message;
	
	public ApiErrorResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	

}
