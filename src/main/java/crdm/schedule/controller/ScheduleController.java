package crdm.schedule.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/section")
public class ScheduleController {

	@GetMapping("")
	public String schedule(Model model) {
		
		Calendar calendar = Calendar.getInstance();
		Integer daysInMonth = calendar.getActualMaximum(calendar.get(Calendar.MONTH));
		
		model.addAttribute("daysInMonth", daysInMonth);
		
		
		return "schedule";
	}
}
