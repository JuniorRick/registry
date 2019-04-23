package crdm.schedule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crdm.schedule.dao.InvestigationDAO;
import crdm.schedule.entity.Investigation;
import crdm.schedule.service.InvestigationService;


@Service
public class InvestigationServiceImpl implements InvestigationService {

	@Autowired
	private InvestigationDAO investigationDAO;
	
	@Override
	@Transactional
	public List<Investigation> all() {
		return investigationDAO.all();
	}

	@Override
	@Transactional
	public Investigation save(Investigation investigation) {
		return investigationDAO.save(investigation);
	}

	@Override
	@Transactional
	public Investigation find(Integer id) {
		return investigationDAO.find(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		investigationDAO.delete(id);

	}

}
