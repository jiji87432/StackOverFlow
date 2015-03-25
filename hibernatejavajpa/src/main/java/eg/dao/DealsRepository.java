package eg.dao;

import org.springframework.data.repository.CrudRepository;

import eg.domain.Deals;

public interface DealsRepository extends CrudRepository<Deals,Long> {

}
