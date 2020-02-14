package org.hibernate.factory;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
	private SessionFactory  sessionFactory;
	private Session session;
	
	private static HibernateFactory uniqueInstance;

	private HibernateFactory() {
	}

	public static synchronized HibernateFactory getInstance() {
		if (uniqueInstance == null)
			JOptionPane.showMessageDialog(null, "CRIOU OBJETO");
			uniqueInstance = new HibernateFactory();

		return uniqueInstance;
	}
	
	
	
	public SessionFactory getSessionFactory() {
		this.sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		return sessionFactory;
	}
	
	public Session getSession() {
		this.session =  this.getSessionFactory().getCurrentSession();
		return session;
	}
	
	
	public void closeConnection() {
		this.session.close();
		this.sessionFactory.close();
	}
	
}
