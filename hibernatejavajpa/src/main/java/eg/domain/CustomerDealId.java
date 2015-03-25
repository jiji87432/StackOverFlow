package eg.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerDealId implements Serializable {

    private static final long serialVersionUID = 9086627167426987610L;

    @Column(name = "DEAL_ID")
    private Long dealId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

	public Long getDealId() {
		return dealId;
	}

	public void setDealId(Long dealId) {
		this.dealId = dealId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

}