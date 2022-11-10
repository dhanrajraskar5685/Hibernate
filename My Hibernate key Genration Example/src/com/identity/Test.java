package com.identity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Product product = new Product();
		product.setPid(101);
		product.setPname("headphone");
		product.setPcode("headphone12");

		Custmor custmor = new Custmor();
		custmor.setCid(122);
		custmor.setName("abc");
		custmor.setCaddress("pune");
		session.save(product);
		session.save(custmor);
		
		Product product1 = new Product();
		product1.setPid(102);
		product1.setPname("phone");
		product1.setPcode("phone12");

		Custmor custmor1 = new Custmor();
		custmor1.setCid(123);
		custmor1.setName("jko");
		custmor1.setCaddress("pmc");
		session.save(product1);
		session.save(custmor1);
		
		
		
		
		
		session.beginTransaction().commit();

	}

}
