package io.github.swahid.todo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * @author  'Saurav Wahid'<wahid.saurav@gmail.com>
 * @since   Nov 26, 2021
 * @version 1.0.1
 */

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Entity
@Table(name = "t_task")
public class Task implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7476860246069234264L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id", nullable = false)
	private Integer taskId;
	
	@Column(name = "title", nullable = false, length = 255)
	private String title;
	
	@Column(name = "description", columnDefinition = "Text")
	private String description;

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", nullable = true)
    private Date startDate;

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", nullable = true)
    private Date endDate;

	@Basic
	private int priorityValue;

	@Transient
	private Priority priority;

	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@Column(name = "is_active")
	private boolean isActive;


	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;


	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@PostLoad
	void fillTransient() {
		if (priorityValue > 0) {
			this.priority = Priority.of(priorityValue);
		}
	}

	@PrePersist
	void fillPersistent() {
		if (priority != null) {
			this.priorityValue = priority.getPriority();
		}
	}
	
}
