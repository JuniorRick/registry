package crdm.schedule.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import crdm.schedule.entity.Doctor;
import crdm.schedule.entity.Investigation;
import crdm.schedule.entity.Section;
import crdm.schedule.service.DoctorService;
import crdm.schedule.service.InvestigationService;
import crdm.schedule.service.SectionService;

@Controller
@RequestMapping("/joins")
public class RelationController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private SectionService sectionService;

	@Autowired
	private InvestigationService investigationService;
	
	private Section section;
	private Doctor doctor;
	
	@GetMapping("")
	public String joins(Model model, @ModelAttribute("section") Section section,
			@ModelAttribute("doctor") Doctor doctor) {

		List<Doctor> doctors = doctorService.all();
		List<Section> sections = sectionService.all();
		
		List<Investigation> investigations = new ArrayList<>();
		
		if (section != null && doctor != null) {
			this.section = section;
			this.doctor = doctor;
			
			investigations = section.getInvestigations();
			model.addAttribute("investigations", investigations);
			model.addAttribute("doctor", doctor);
		}

		model.addAttribute("sections", sections);
		model.addAttribute("doctors", doctors);
		
		return "joins";
	}

	@GetMapping("/filter")
	public String filter(@RequestParam("section_id") Integer section_id, @RequestParam("doctor_id") Integer doctor_id,
			Model model, final RedirectAttributes redirectAttributes) {

		Doctor doctor = doctorService.find(doctor_id);
		Section section = sectionService.find(section_id);
		redirectAttributes.addFlashAttribute("doctor", doctor);
		redirectAttributes.addFlashAttribute("section", section);

		return "redirect:/joins";

	}
	
	@ResponseBody
	@GetMapping("/assign/{id}")
	public String assign(@PathVariable("id") Integer id) {
		
		String returnString = "";
		List<Investigation> investigations = this.doctor.getInvestigations();
		Investigation investigation = investigationService.find(id);
		
		int index = investigations.stream().map(i -> i.getId()).collect(Collectors.toList()).indexOf(id);
		System.out.println(index);
		if(index >= 0) {
			investigations.remove(index);
			returnString = "removed";
			System.out.println(returnString);
		} else {
			investigations.add(investigation);
			returnString = "added";
			System.out.println(returnString);
		}
		System.out.println(investigations.size());
		doctor.setInvestigations(investigations);
		doctorService.save(doctor);
		
		return returnString;
	}

}
