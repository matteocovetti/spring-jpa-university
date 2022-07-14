package jana60.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.repository.DepartmentsRepository;

@Controller
@RequestMapping("/")
public class DepartmentsController {

	@Autowired
	private DepartmentsRepository repo;

	@GetMapping
	public String departments() {
		return "departments";
	}
}
