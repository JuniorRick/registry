package crdm.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import crdm.schedule.entity.Section;
import crdm.schedule.service.SectionService;

@Controller
public class HomeController {
	
	@Autowired
	SectionService sectionService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Section> sections = sectionService.all();
		
		model.addAttribute("sections", sections);
		
		return "index";
	}
}
