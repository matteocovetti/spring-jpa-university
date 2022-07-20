package jana60.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import jana60.model.Teachers;
import jana60.repository.TeachersRepository;

@Controller
@RequestMapping("/teachers")
public class TeachersController {

	@Autowired
	private TeachersRepository repo;

	@GetMapping
	public String teachers(Model model) {
		model.addAttribute("teachersList", repo.findAll());
		return "teachers";
	}

	@GetMapping("/{teacherId}")
	public String teachersDetail(@PathVariable(name = "teacherId") Integer teacherId, Model model) {
		Optional<Teachers> queryResult = repo.findById(teacherId);
		if (queryResult.isPresent()) {
			model.addAttribute("teachers", queryResult.get());
			return "teachersDetail";
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found");
		}
	}
}
