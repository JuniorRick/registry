package crdm.schedule.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import crdm.schedule.entity.Section;
import crdm.schedule.service.SectionService;

@Controller
@RequestMapping("/sections")
public class SectionController {

	@Autowired
	private SectionService sectionService;
	
	@GetMapping("")
	public String all(@ModelAttribute("section") Section section, Model model) {
		
		List<Section> sections = sectionService.all();
		
		if(section == null) {
			section = new Section();
		}
		
		model.addAttribute("sections", sections);
		model.addAttribute("section", section);
		
		return "sections";
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute("section") Section section) throws IOException {
		    
		sectionService.save(section);
		
		return "redirect:/sections";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("Id") int id, final RedirectAttributes redirectAttributes) {

		Section section= sectionService.find(id);
		redirectAttributes.addFlashAttribute("section", section);
		
		return "redirect:/sections";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("Id") int id, Model model) {

		sectionService.delete(id);
		
		return "redirect:/sections";
	}
	
}
