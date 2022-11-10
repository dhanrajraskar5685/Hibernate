package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = Hibernate.getSessionFactory();

		Session session = sf.openSession();

//		Company Company = new Company();
//		Company.setSid(101);
//		Company.setCname("tcs");
//		Company.setCaddress("pune");
//
//		session.save(Company);
//		session.beginTransaction().commit();
//		System.out.println("Done");

		Company company1 = session.get(Company.class, 1);
		System.out.println(company1);
		System.out.println("+++++++++++++++++++++++++++++++++++");
		session.evict(company1);
		Company company2 = session.get(Company.class, 1);
		System.out.println(company2);
	}

}
