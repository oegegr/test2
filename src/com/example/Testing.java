package com.example;

import org.hibernate.Session;

import com.example.dto.Address;
import com.example.dto.UserDetails;
import com.example.hibernate.HibernateUtilities;


public class Testing {
	public static void main(String[] args) {
		
		Session session =  HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		Address addr = new Address("Moscow", "Polarnaya st", "Moscow", "123321");
		Address addr2 = new Address("St. Petersburg", "Nevskiy pr", "St. Petersburg", "654456");
		Address addr3 = new Address("St. Petersburg", "Otradniy pr", "St. Petersburg", "23213");
		Address addr4 = new Address("St. Petersburg", "Mira pr", "St. Petersburg", "323213");
		UserDetails user = new UserDetails("John Doe", "description of user");
		UserDetails user2 = new UserDetails("Tom Smith", "description of user2");
		user.getListOfAddress().add(addr);
		user.getListOfAddress().add(addr2);
		user2.getListOfAddress().add(addr3);
		user2.getListOfAddress().add(addr4);
		System.out.println("testing user id " + user.getUserId() + " name " + user.getUserName());
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		
		user = null;
		session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User name retrived is " + user.getUserName());
		session.close();
		
		session.getSessionFactory().close();
	}

}
