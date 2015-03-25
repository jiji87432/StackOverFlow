package eg.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_DEALS")
public class CustomerDeals implements Serializable {
    private static final long serialVersionUID = -4249326793843278525L;

    @EmbeddedId
    private CustomerDealId customerDealId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DEAL_ID", insertable = false, updatable = false)
    private Deals deals;

	public CustomerDealId getCustomerDealId() {
		return customerDealId;
	}

	public void setCustomerDealId(CustomerDealId customerDealId) {
		this.customerDealId = customerDealId;
	}


	public Deals getDeals() {
		return deals;
	}

	public void setDeals(Deals deals) {
		this.deals = deals;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

   //getters setters

}
