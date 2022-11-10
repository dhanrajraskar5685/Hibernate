package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Product product = new Product();
		product.setId(101);
		product.setName("mobile");
		product.setPrice(1000);
		product.setPtype("electronic");
		session.save(product);
		session.beginTransaction().commit();

	}

}
