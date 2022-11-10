package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Employee employee = new Employee();
		employee.setEid(12);
		employee.setEname("Raskar");
		employee.setEaddress("pune");
		employee.setCname("facebook");
		employee.setSalary(90000000);

		session.saveOrUpdate(employee);
		session.beginTransaction().commit();
		System.out.println("Done");
	}

}
