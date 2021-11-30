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

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="t_status")
public class Status extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 2422840202333290973L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "status_id", nullable = false, unique = true)
	private Integer statusId;
	
	@Column(name = "status_name", nullable = false, unique = true)
	private String statusName;
	
	@Column(name = "status_weight", nullable = false, unique = true)
	private Integer statusWeight;

	@JsonIgnore
	@OneToMany(mappedBy="status")
	private List<Task> taskEntry;
}
