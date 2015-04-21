package org.arunm.models;

import javax.transaction.Transactional;

/**
 * Repository for the entity Person.
 * 
 * @see netgloo.models.UserBaseRepository
 */
@Transactional
public interface EmployeeRepository extends PersonRepository<Employee> { }
