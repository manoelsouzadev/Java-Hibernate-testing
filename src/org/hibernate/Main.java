package org.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.dao.HibernateDao;
import org.hibernate.factory.HibernateFactory;
import org.hibernate.models.User;

public class Main {

	public static void main(String[] args) {
		HibernateFactory hibernateFactory = HibernateFactory.getInstance();
		HibernateDao hibernateDao =  HibernateDao.getInstance();
		Session session = hibernateFactory.getSession();

		// SessionFactory sessionFactory = new
		// Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// SessionFactory sessionFactory = new
		// Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

		// Session session = sessionFactory.getCurrentSession();

		try {
			// List<User> users = new ArrayList<User>();
			
			User user = new User("func", "65767666");
			//user.setId(10);
			//hibernateDao.find(user, user.getId());
			//hibernateDao.save(user);
			hibernateDao.findAll("from users");
			// User user2 = new User("singleton 4", "19:46");
			// User user2 = new User("maria", "12345678");
			// users.add(user);
			// users.add(user2);

			//session.beginTransaction();
//			for (User fuser : users) {
//				session.save(fuser);
//				
//			}
//			session.save(user);
//			session.getTransaction().commit();

			
		} finally {
			// session.close();
			// sessionFactory.close();
			// HibernateFactory.close();
			hibernateFactory.closeConnection();
		}
	}
}
