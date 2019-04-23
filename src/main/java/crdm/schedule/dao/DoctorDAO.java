package crdm.schedule.dao;

import java.util.List;

import crdm.schedule.entity.Doctor;

public interface DoctorDAO {
	
	public List<Doctor> all();
	
	public Doctor save(Doctor doctor);
	
	public Doctor find(Integer id);
	
	void delete(Integer id);
}
