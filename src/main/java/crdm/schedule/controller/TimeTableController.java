package crdm.schedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timetable")
public class TimeTableController {

	@GetMapping("")
	public String timeTable() {
		
		return "timetable";
	}
}
