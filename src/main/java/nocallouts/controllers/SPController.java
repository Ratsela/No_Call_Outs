package nocallouts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nocallouts.model.Problem;
import nocallouts.service.ProblemService;

@Controller
@RequestMapping("")
public class SPController {
	
	@Autowired
	private ProblemService problemService;
	
	@RequestMapping(value="/requests",method=RequestMethod.GET)
	public String getProblemsPage(Model model)
	{
		model.addAttribute("problems", problemService.getAllProblems());
		return "views/problems";
	}
	
	@RequestMapping(value="/requestsJSON",method=RequestMethod.GET)
	public ResponseEntity<List<Problem>> getProblems()
	{
		return new ResponseEntity<>(problemService.getAllProblems(), HttpStatus.OK);
	}

}
