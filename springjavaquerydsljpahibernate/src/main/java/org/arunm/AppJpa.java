package org.arunm;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.arunm.domain.QEmpresa;

import com.mysema.query.jpa.impl.JPAQuery;

/**
 * Hello world!
 *
 */
public class AppJpa 
{
		
    public static void main( String[] args )
    {
    	

        
        /*QEmpresa qEmpresa = QEmpresa.empresa;*/
        
  /*      final Object emDelegate = entityManager.getDelegate();
        Session session = (Session)emDelegate;
        session.enableFetchProfile("WITH_PROVEEDORES");
        
        
        JPAQuery query = new JPAQuery (entityManager); 
        query.from(qEmpresa);
        List list = query.list(qEmpresa);*/
        
       /* QProveedor qProveedor = QProveedor.proveedor;
        
        JPAQuery query = new JPAQuery (entityManager); 
        query.from(qProveedor);
        List list = query.list(qProveedor);*/
        
    	//entityManager.create
    	
    	//queryWithProveedors(entityManager);
    	queryWithProveedors();
     
    }

	private static void queryWithOutProveedors() {
    	EntityManager entityManager = Persistence.createEntityManagerFactory("tutorialPU").
    			createEntityManager();
		QEmpresa qEmpresa = QEmpresa.empresa;
		JPAQuery query = new JPAQuery(entityManager);
        query.from(qEmpresa);
         query.list(qEmpresa);
	}

	private static void queryWithProveedors() {
    	EntityManager entityManager = Persistence.createEntityManagerFactory("tutorialPU").
    			createEntityManager();
		QEmpresa qEmpresa = QEmpresa.empresa;
		JPAQuery query = new JPAQuery (entityManager); 
    	EntityGraph graph = entityManager.getEntityGraph("WITH_PROVEEDORES");
    	query.from(qEmpresa).setHint("javax.persistence.fetchgraph", graph);
    	query.list(qEmpresa);
		
	}
}
