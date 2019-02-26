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

import crdm.schedule.dao.SectionDAO;
import crdm.schedule.entity.Section;


@Repository
public class SectionDAOImpl implements SectionDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Section> all() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Section> cq = cb.createQuery(Section.class);
		Root<Section> root = cq.from(Section.class);
		
		CriteriaQuery<Section> all = cq.select(root);
		
		TypedQuery<Section> allQuery = session.createQuery(all);
		
		return allQuery.getResultList();
	}

	@Override
	public Section save(Section section) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(section);
		return section;
	}

	@Override
	public Section find(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.find(Section.class, id);
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Section section = session.find(Section.class, id);
		
		session.delete(section);
		
	}

}
