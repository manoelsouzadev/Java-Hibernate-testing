package org.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.models.User;

public class Main {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
//		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")..addAnnotatedClass(User.class)
//		.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			// List<User> users = new ArrayList<User>();
			User user = new User("teste sem addAnnoted", "321");
			// User user2 = new User("maria", "12345678");
			// users.add(user);
			// users.add(user2);

			session.beginTransaction();
//			for (User fuser : users) {
//				session.save(fuser);
//				
//			}
			session.save(user);
			session.getTransaction().commit();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
