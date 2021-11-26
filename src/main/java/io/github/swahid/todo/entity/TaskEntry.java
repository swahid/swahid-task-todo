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

@Getter
@Setter
@Entity
@Table(name = "t_task_entry")
public class TaskEntry extends BaseEntity implements Serializable{

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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", nullable = true)
    private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", nullable = true)
    private Date endDate;
	
	@ManyToOne
    @JoinColumn(name="priority_id", nullable=true)
	private Priority priority;
	
	@ManyToOne
    @JoinColumn(name="status_id", nullable=true)
	private Status status;
	
   
	
}
