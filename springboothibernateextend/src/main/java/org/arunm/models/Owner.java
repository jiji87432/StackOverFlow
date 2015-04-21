package org.arunm.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Company entity (a subtype of User).
 * 
 * @see Person.models.User
 */
@Entity
@AttributeOverrides({
    @AttributeOverride(name="email", column=@Column(name="email"))
})
@Table(name = "Owner")
public class Owner extends Person {

  // ==============
  // PRIVATE FIELDS
  // ==============
  // Company's name
  @Column
  private String name;

  // Company's headquarters city
  @Column
  private String hqCity;
 
  // ==============
  // PUBLIC METHODS
  // ==============
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the hqCity
   */
  public String getHqCity() {
    return hqCity;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @param hqCity the hqCity to set
   */
  public void setHqCity(String hqCity) {
    this.hqCity = hqCity;
  }


} // class Company
