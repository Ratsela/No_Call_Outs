package nocallouts.repository;

import org.springframework.data.repository.CrudRepository;

import nocallouts.model.HomeOwner;

public interface HomeOwnerRepository extends CrudRepository<HomeOwner, String> {

}
