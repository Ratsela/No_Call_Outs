package nocallouts.repository;

import org.springframework.data.repository.CrudRepository;

import nocallouts.model.ServiceProvider;

public interface ServiceProviderRepository extends CrudRepository<ServiceProvider, String> {

}
