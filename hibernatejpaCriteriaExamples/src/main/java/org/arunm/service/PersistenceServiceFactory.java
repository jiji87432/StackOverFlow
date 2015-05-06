package org.arunm.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.arunm.model.Employee;
import org.arunm.model.Employee_;
import org.arunm.model.OnetoOneBar;
import org.arunm.model.OnetoOneBar_;
import org.arunm.model.OnetoOneFoo;
import org.arunm.model.OnetoOneFoo_;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersistenceServiceFactory {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	 @Autowired
	 private SessionFactory sessionFactory;
	 
	public void getPersistenceServiceFactory(){
		System.out.println("getPersistenceServiceFactory");
		final HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory) entityManagerFactory;
       // final SessionFactory sessionFactory = emFactory.getSessionFactory(); 
        sessionFactory.getCurrentSession();
        System.out.println("getPersistenceServiceFactory sessionFactory");
	}
	
	public List<Employee> getTest1(){
	
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> c = qb.createQuery(Employee.class);
		Root<Employee> p = c.from(Employee.class);
		Predicate condition = qb.equal(p.get(Employee_.email), "ntarunmenon@gmail.com");
		c.where(condition);
		TypedQuery<Employee> q = entityManager.createQuery(c); 
		List<Employee> result = q.getResultList();
		return result;
	}
	
	public Employee getTest2(){
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = qb.createQuery(Employee.class);
		Root<Employee> emRoot = criteriaQuery.from(Employee.class);
		Path<String> path = emRoot.get(Employee_.firstName);
		criteriaQuery.where(qb.equal(path, "Arun"));
		TypedQuery<Employee> q = entityManager.createQuery(criteriaQuery); 
		return q.getSingleResult();
	}
	
	public List<OnetoOneFoo> getTest3(){
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
		CriteriaQuery<OnetoOneFoo> criteriaQuery = qb.createQuery(OnetoOneFoo.class);
		Root<OnetoOneFoo> onetooneFooRoot =criteriaQuery.from(OnetoOneFoo.class);
		Path<OnetoOneBar> onetooneBarPath = onetooneFooRoot.get(OnetoOneFoo_.onetoOneBar);
		Path<String> barDescPath = onetooneBarPath.get(OnetoOneBar_.barDesc);
		
		criteriaQuery.where(qb.in(barDescPath).value("bar11").value("bar12"));
		TypedQuery<OnetoOneFoo> q = entityManager.createQuery(criteriaQuery); 
		return q.getResultList();
	}
	
	public List<OnetoOneFoo> getTest4(){
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
		CriteriaQuery<OnetoOneFoo> criteriaQuery = qb.createQuery(OnetoOneFoo.class);
		Root<OnetoOneFoo> onetooneFooRoot = criteriaQuery.from(OnetoOneFoo.class);
		Join<OnetoOneFoo,OnetoOneBar > join = onetooneFooRoot.join(OnetoOneFoo_.onetoOneBar);
		Predicate predicate = qb.equal(join.get(OnetoOneBar_.barId), 1);
		criteriaQuery.where(predicate);
		TypedQuery<OnetoOneFoo> q = entityManager.createQuery(criteriaQuery); 
		return q.getResultList();
		
		
	}
}
