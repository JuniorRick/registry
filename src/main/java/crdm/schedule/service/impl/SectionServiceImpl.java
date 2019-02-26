package crdm.schedule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crdm.schedule.dao.SectionDAO;
import crdm.schedule.entity.Section;
import crdm.schedule.service.SectionService;


@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	private SectionDAO sectionDAO;
	
	@Override
	@Transactional
	public List<Section> all() {
		return sectionDAO.all();
	}

	@Override
	@Transactional
	public Section save(Section section) {
		return sectionDAO.save(section);
	}

	@Override
	@Transactional
	public Section find(Integer id) {
		return sectionDAO.find(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		sectionDAO.delete(id);

	}

}
