package eg.config.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eg.dao.CustomerRepository;
import eg.dao.DealsRepository;
import eg.domain.Customer;
import eg.domain.Deals;

@Component
public class PersistentContextService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private DealsRepository dealsRepository;
	
	@Transactional
	public Long insertCustomer(Customer customer){
		customer.setName("NewCus");
		customer.getDeals().add(dealsRepository.findOne(new Long(1)));
		
		customerRepository.save(customer);
		
		return customer.getId();
	}
	
	@Transactional
	public Long insertDeal(Deals deals){
		dealsRepository.save(deals);
		return deals.getDealId();
	}

	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public DealsRepository getDealsRepository() {
		return dealsRepository;
	}

	public void setDealsRepository(DealsRepository dealsRepository) {
		this.dealsRepository = dealsRepository;
	}
	
	
}
