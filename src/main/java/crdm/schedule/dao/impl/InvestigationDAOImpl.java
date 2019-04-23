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

import crdm.schedule.dao.InvestigationDAO;
import crdm.schedule.entity.Investigation;


@Repository
public class InvestigationDAOImpl implements InvestigationDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Investigation> all() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Investigation> cq = cb.createQuery(Investigation.class);
		Root<Investigation> root = cq.from(Investigation.class);
		
		CriteriaQuery<Investigation> all = cq.select(root);
		
		TypedQuery<Investigation> allQuery = session.createQuery(all);
		
		return allQuery.getResultList();
	}

	@Override
	public Investigation save(Investigation investigation) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(investigation);
		return investigation;
	}

	@Override
	public Investigation find(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.find(Investigation.class, id);
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Investigation investigation = session.find(Investigation.class, id);
		
		session.delete(investigation);
		
	}

}
