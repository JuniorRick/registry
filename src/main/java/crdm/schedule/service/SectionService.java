package crdm.schedule.service;

import java.util.List;

import crdm.schedule.entity.Section;

public interface SectionService {
	public List<Section> all();

	public Section save(Section section);

	public Section find(Integer id);

	void delete(Integer id);

}
