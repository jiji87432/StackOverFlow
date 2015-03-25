package eg.dao;

import org.springframework.data.repository.CrudRepository;

import eg.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
