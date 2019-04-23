package crdm.schedule.dao;

import java.util.List;

import crdm.schedule.entity.Investigation;

public interface InvestigationDAO {
	
	public List<Investigation> all();
	
	public Investigation save(Investigation investigation);
	
	public Investigation find(Integer id);
	
	void delete(Integer id);
}
