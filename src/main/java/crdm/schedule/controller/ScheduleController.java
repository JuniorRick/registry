package crdm.schedule.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import crdm.schedule.entity.Doctor;
import crdm.schedule.entity.Investigation;
import crdm.schedule.entity.Section;
import crdm.schedule.service.SectionService;

@Controller
@RequestMapping("/scheduling")
public class ScheduleController {

	@Autowired
	SectionService sectionService;
	
	@GetMapping("/{section_id}")
	public String schedule(Model model, @PathVariable("section_id") Integer id) {
		
		Section section = sectionService.find(id);
		List<Investigation> investigations = section.getInvestigations();
		
		Set<Doctor> doctors = new HashSet<>();
		
		
		for(Investigation i : investigations) {
			doctors.addAll(i.getDoctors());
		}
		
		model.addAttribute("section", section);
		model.addAttribute("doctors", doctors);
		
		
		return "schedule";
	}
}
