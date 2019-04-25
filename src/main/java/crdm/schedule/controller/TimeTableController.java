package crdm.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import crdm.schedule.entity.Doctor;
import crdm.schedule.service.DoctorService;

@Controller
@RequestMapping("/timetable")
public class TimeTableController {

	@Autowired
	private DoctorService doctorService;
	
	
	@GetMapping("")
	public String timeTable(Model model) {
		
		List<Doctor> doctors = doctorService.all();
		
		model.addAttribute("doctors", doctors);
		
		return "timetable";
	}
	
	
}
