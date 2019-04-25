package crdm.schedule.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import crdm.schedule.entity.Doctor;
import crdm.schedule.entity.Investigation;
import crdm.schedule.service.DoctorService;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("")
	public String all(@ModelAttribute("doctor") Doctor doctor, Model model) {
		
		List<Doctor> doctors = doctorService.all();
		
		if(doctor == null) {
			doctor = new Doctor();
		}
		
		model.addAttribute("doctors", doctors);
		model.addAttribute("doctor", doctor);
		
		return "doctors";
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute("doctor") Doctor doctor) throws IOException {
		    
		doctorService.save(doctor);
		
		return "redirect:/doctors";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("Id") int id, final RedirectAttributes redirectAttributes) {

		Doctor doctor= doctorService.find(id);
		redirectAttributes.addFlashAttribute("doctor", doctor);
		
		return "redirect:/doctors";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("Id") int id, Model model) {

		doctorService.delete(id);
		
		return "redirect:/doctors";
	}
	
	@GetMapping("/{id}/investigations")
	@ResponseBody
	public List<Investigation> timeTable(@PathVariable(name="id") Integer id) {
		
		List<Investigation> investigations = doctorService.find(id).getInvestigations();
		return investigations;
	}
	
}
