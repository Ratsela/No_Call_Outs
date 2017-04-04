package nocallouts.repository;

import org.springframework.data.repository.CrudRepository;

import nocallouts.model.Problem;

public interface ProblemRepository extends CrudRepository<Problem, String> {

}
