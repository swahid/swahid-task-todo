/**
 * 
 */
package io.github.swahid.todo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author  'Saurav Wahid'<wahid.saurav@gmail.com>
 * @since   Nov 26, 2021
 * @version 1.0.1
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedDate;


}