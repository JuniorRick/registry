package crdm.schedule.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@ManyToMany
	@JoinTable(name = "doctor_investigation", joinColumns = { @JoinColumn(name = "doctor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "investigation_id") })
	private Set<Investigation> investigations = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Investigation> getInvestigations() {
		return investigations;
	}

	public void setInvestigations(Set<Investigation> investigations) {
		this.investigations = investigations;
	}

}
