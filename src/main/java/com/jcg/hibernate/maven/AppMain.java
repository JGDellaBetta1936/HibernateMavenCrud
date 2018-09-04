package com.jcg.hibernate.maven;

import java.util.Date;

import javax.swing.text.DefaultEditorKit.InsertTabAction;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppMain {

	static User userObj;
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;
	static Logger log = Logger.getLogger(AppMain.class.getName() );

	private static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 

		// Creating Hibernate SessionFactory Instance
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static void main(String[] args) {
		log.info(".......Hibernate Maven Example.......");
		insertRows();
		updateRows();
		deleteRows();
		System.exit(0);
	}
	
	private static void insertRows() {
		sessionObj = buildSessionFactory().openSession();
		sessionObj.beginTransaction();
		for(int i = 101; i <= 115; i++) {
			userObj = new User();
			userObj.setUserid(i);
			userObj.setUsername("Editor " + i);
			userObj.setCreatedBy("Administrator");
			userObj.setCreatedDate(new Date());
			sessionObj.saveOrUpdate(userObj);
		}
		sessionObj.getTransaction().commit();
		sessionObj.close();
		log.info("inserts completed.");
	}
	
	private static void updateRows() {
		sessionObj = buildSessionFactory().openSession();
		sessionObj.beginTransaction();
		for(int i = 101; i <= 115; i++) {
			userObj = new User(i);
			userObj.setUsername("Editor Updated" + i);
			userObj.setCreatedBy("Administrator Updated");
			userObj.setCreatedDate(new Date());
			sessionObj.saveOrUpdate(userObj);
		}		
		sessionObj.getTransaction().commit();
		sessionObj.close();
		log.info("Updates completed.");
	}
	private static void deleteRows() {
		sessionObj = buildSessionFactory().openSession();
		sessionObj.beginTransaction();
		for(int i = 101; i <= 115; i++) {
			userObj = new User(i);
			sessionFactoryObj.getCache();
			sessionObj.delete(userObj);
		}
		sessionObj.getTransaction().commit();
		sessionObj.close();
		log.info("Deletes completed.");
	}
	
}