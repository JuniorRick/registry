package crdm.schedule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crdm.schedule.dao.DoctorDAO;
import crdm.schedule.entity.Doctor;
import crdm.schedule.service.DoctorService;


@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDAO doctorDAO;
	
	@Override
	@Transactional
	public List<Doctor> all() {
		return doctorDAO.all();
	}

	@Override
	@Transactional
	public Doctor save(Doctor doctor) {
		return doctorDAO.save(doctor);
	}

	@Override
	@Transactional
	public Doctor find(Integer id) {
		return doctorDAO.find(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		doctorDAO.delete(id);

	}

}
