package nocallouts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nocallouts.model.Problem;
import nocallouts.repository.ProblemRepository;

@Service
public class ProblemService {

	@Autowired
	private ProblemRepository pr;
	
	public void addProblem(Problem problem)
	{
		pr.save(problem);
	}
	public List<Problem> getAllProblems()
	{
		List<Problem> problems = new ArrayList<>();
		pr.findAll().forEach(problems::add);
		return problems;
	}
	public Problem findByEmail(String email)
	{
		return pr.findOne(email);
	}
}
