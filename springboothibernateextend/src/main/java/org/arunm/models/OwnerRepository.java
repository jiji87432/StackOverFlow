package org.arunm.models;

import javax.transaction.Transactional;

/**
 * Repository for the entity Company.
 * 
 * @see netgloo.models.UserBaseRepository
 */
@Transactional
public interface OwnerRepository extends PersonRepository<Owner> { }
