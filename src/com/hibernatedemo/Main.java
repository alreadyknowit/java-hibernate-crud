package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {


	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			//READ

			//			List<City> cities =session.createQuery("from City c where c.countryCode='USA' AND c.district='Washington'").getResultList();
			//
			//			for(City c: cities) {
			//				System.out.println(c.getName());
			//			}
			//CREATE
			//			  City city = new City(); city.setName("Selanik"); city.setCountryCode("TUR");
			//			  city.setDistrict("Akdeniz"); city.setPopulation(1789250);
			//			  
			//			  session.save(city);

			//UPDATE
			//			City city = session.get(City.class, 3357); //Update Istanbul's population to 1
			//			System.out.println(city.getName());
			//			city.setPopulation(1);
			//			session.save(city);

			//DELETE
			//			City city = session.get(City.class, 3358); //delete Ankara
			//			session.delete(city);
			session.getTransaction().commit();

		}finally {
			factory.close();
			session.close();
		}


	}
}
