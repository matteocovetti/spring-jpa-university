package jana60.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.repository.CoursesRepository;

@Controller
@RequestMapping("/courses")
public class CoursesController {

	@Autowired
	private CoursesRepository repo;

	@GetMapping
	public String courses(Model model) {
		model.addAttribute("coursesList", repo.findAll());
		return "courses";
	}
}
