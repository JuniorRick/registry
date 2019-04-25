package crdm.schedule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "timetable")
public class HourTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String hourDisabled;
	
	private String minuteDisabled;
	
	@ManyToOne
    @JoinColumn(name="timetable_id", nullable=false)
	private TimeTable timetable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHourDisabled() {
		return hourDisabled;
	}

	public void setHourDisabled(String hourDisabled) {
		this.hourDisabled = hourDisabled;
	}

	public String getMinuteDisabled() {
		return minuteDisabled;
	}

	public void setMinuteDisabled(String minuteDisabled) {
		this.minuteDisabled = minuteDisabled;
	}
	
	
}
