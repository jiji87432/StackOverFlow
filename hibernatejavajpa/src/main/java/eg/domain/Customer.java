package eg.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer implements Serializable {

    private static final long serialVersionUID = -5419345600310440297L;
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long id;
  
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name="CUSTOMER_DEALS",
            joinColumns = @JoinColumn( name="CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn( name="DEAL_ID")
    )
    private Set<Deals> deals = new HashSet<Deals>();
	
    
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Deals> getDeals() {
		return deals;
	}
	public void setDeals(Set<Deals> deals) {
		this.deals = deals;
	}

    //getters and setters goes here ....
}