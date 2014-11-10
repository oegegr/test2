package com.example.hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static final SessionFactory buildSessionFactory() {
		try {
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				System.out.println("Hibernate configuration is loaded");
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate service Registry created");
				
				SessionFactory sessionFactory = configuration
						.buildSessionFactory(serviceRegistry);
				
				return sessionFactory;
		}
		catch (Throwable ex) {
			System.err.println("Ininitial SessionFactory creation failed" + ex);
			throw new ExceptionInInitializerError(ex);
		}

	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}

