package eg.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEALS")
public class Deals implements Serializable {

    private static final long serialVersionUID = -7197428343863081750L;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "DEAL_ID")
    private Long dealId;

    @Column(name = "DEAL_NAME")
    private String dealColName;

	public Long getDealId() {
		return dealId;
	}

	public void setDealId(Long dealId) {
		this.dealId = dealId;
	}

	public String getDealColName() {
		return dealColName;
	}

	public void setDealColName(String dealColName) {
		this.dealColName = dealColName;
	}

    //getters setters
}
