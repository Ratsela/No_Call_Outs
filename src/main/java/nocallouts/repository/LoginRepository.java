package nocallouts.repository;

import org.springframework.data.repository.CrudRepository;

import nocallouts.model.Login;

public interface LoginRepository extends CrudRepository<Login, String> {

}
