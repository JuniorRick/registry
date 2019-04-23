package crdm.schedule.service;

import java.util.List;

import crdm.schedule.entity.Investigation;

public interface InvestigationService {
	public List<Investigation> all();

	public Investigation save(Investigation investigation);

	public Investigation find(Integer id);

	void delete(Integer id);

}
