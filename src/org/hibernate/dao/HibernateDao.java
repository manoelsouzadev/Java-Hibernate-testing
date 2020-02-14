package org.hibernate.dao;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.factory.HibernateFactory;

public class HibernateDao {
	private HibernateFactory hibernateFactory = HibernateFactory.getInstance();
	private Session session = hibernateFactory.getSession();

	private static HibernateDao uniqueInstance;

	private HibernateDao() {
	}

	public static synchronized HibernateDao getInstance() {
		if (uniqueInstance == null)
			JOptionPane.showMessageDialog(null, "CRIOU OBJETO");
		uniqueInstance = new HibernateDao();

		return uniqueInstance;
	}

	public void save(Object object) {
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
	}
	
	public void update(Object object) {
		session.beginTransaction();
		session.merge(object);
		session.getTransaction().commit();
	}
	
	public void remove(Object object) {
		session.beginTransaction();
		session.remove(object);
		session.getTransaction().commit();
	}
	
	public void find(Object object, long id) {
		session.beginTransaction();
		System.out.println(session.find(object.getClass(), id).toString());
		session.getTransaction().commit();
		
	}
	public void findAll(String query) {
		session.beginTransaction();
		System.out.println(session.createQuery(query).getResultList());
		session.getTransaction().commit();
		
	}
}
