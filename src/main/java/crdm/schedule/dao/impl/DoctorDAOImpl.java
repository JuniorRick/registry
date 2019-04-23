package crdm.schedule.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import crdm.schedule.dao.DoctorDAO;
import crdm.schedule.entity.Doctor;


@Repository
public class DoctorDAOImpl implements DoctorDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Doctor> all() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Doctor> cq = cb.createQuery(Doctor.class);
		Root<Doctor> root = cq.from(Doctor.class);
		
		CriteriaQuery<Doctor> all = cq.select(root);
		
		TypedQuery<Doctor> allQuery = session.createQuery(all);
		
		return allQuery.getResultList();
	}

	@Override
	public Doctor save(Doctor doctor) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(doctor);
		return doctor;
	}

	@Override
	public Doctor find(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.find(Doctor.class, id);
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Doctor doctor = session.find(Doctor.class, id);
		
		session.delete(doctor);
		
	}

}
