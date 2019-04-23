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

import crdm.schedule.entity.Investigation;
import crdm.schedule.entity.Section;
import crdm.schedule.service.InvestigationService;
import crdm.schedule.service.SectionService;

@Controller
@RequestMapping("/investigations")
public class InvestigationController {

	@Autowired
	private InvestigationService investigationService;

	@Autowired
	private SectionService sectionService;

	@GetMapping("")
	public String all(@ModelAttribute("investigation") Investigation investigation, Model model) {

		List<Investigation> investigations = investigationService.all();
		List<Section> sections = sectionService.all();

		if (investigation == null) {
			investigation = new Investigation();
		}

		model.addAttribute("sections", sections);
		model.addAttribute("investigations", investigations);
		model.addAttribute("investigation", investigation);

		return "investigations";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("investigation") Investigation investigation,
			@RequestParam("section_id") int section_id) throws IOException {

		investigation.setSection(sectionService.find(section_id));
		investigationService.save(investigation);

		return "redirect:/investigations";
	}

	@GetMapping("/update")
	public String update(@RequestParam("Id") int id, final RedirectAttributes redirectAttributes) {

		Investigation investigation = investigationService.find(id);
		redirectAttributes.addFlashAttribute("investigation", investigation);

		return "redirect:/investigations";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("Id") int id, Model model) {

		investigationService.delete(id);

		return "redirect:/investigations";
	}

}
