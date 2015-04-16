package org.arunm;

import org.arunm.domain.Empresa;
import org.arunm.util.HibernateUtil;
import org.hibernate.Session;


public class AppHibernate {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        session.enableFetchProfile("WITH_PROVEEDORES");
        
        Empresa empresa= (Empresa)session.get(Empresa.class, new String("1"));
        
        session.disableFetchProfile("WITH_PROVEEDORES");
        
        session.getTransaction().commit();
        
        
        session = HibernateUtil.getSessionFactory().getCurrentSession();
       
        
        session.beginTransaction();
        
        
        Empresa empresaWithout= (Empresa)session.get(Empresa.class, new String("1"));
        
        
        session.getTransaction().commit();
        
	}
}
