package io.github.swahid.todo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author  'Saurav Wahid'<wahid.saurav@gmail.com>
 * @since   Nov 26, 2021
 * @version 1.0.1
 */

@Getter
@Setter
@Entity
@Table(name="t_priority")
public class Priority extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 2213140970611400177L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "priority_id", nullable = false, unique = true)
	private Integer priorityId;
	
	@Column(name = "priority_name", nullable = false, unique = true)
	private String priorityName;
	
	@Column(name = "priority_weight", nullable = false, unique = true)
	private Integer priorityWeight;
	
	@OneToMany(mappedBy="priority")
	private List<Task> taskEntry;

}
