package org.arunm.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Person entity (a subtype of User).
 * 
 * @see Person.models.Aperson
 */
@Entity
@AttributeOverrides({
    @AttributeOverride(name="email", column=@Column(name="email"))
})
@Table(name = "Employee")
public class Employee extends Person {

  // ==============
  // PRIVATE FIELDS
  // ==============
  // Person's first name
  @Column
  private String firstName;

  //Person's last name
  @Column
  private String lastName;
 
  // ==============
  // PUBLIC METHODS
  // ==============
  
  /**
   * Default Person constructor
   */
  public Employee() { }

  /**
   * Build a new Person with the passed id.
   */
  public Employee(Long id) {
    this.setId(id);
  }
  
  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

} // class Person
