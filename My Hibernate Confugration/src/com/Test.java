package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

//		product product = new product();
//		product.setPid(1220);
//		product.setPname("electronic");
//		product.setPtype("laptop");
//		product.setPrice("2500");
//
//		product product1 = new product();
//		product1.setPid(1225);
//		product1.setPname("electronic");
//		product1.setPtype("laptop");
//		product1.setPrice("2500");
//
//		session.save(product);
//		session.save(product1);

		// session.begin.Transaction().commit();

		// select * from product
		Query<product> query = session.createQuery("from product");
		List<product> plist = query.getResultList();
		System.out.println(plist);

		// select * from product where pid=1
		Session session1 = sf.openSession();
		product product1 = session1.get(product.class, 2);
		System.out.println(product1);

		product1.setPname("mobile1");
		product1.setPrice("35000");
		session1.update(product1);

		Session session2 = sf.openSession();
		product product2 = session2.get(product.class, 1);
		System.out.println(product2);
		session2.delete(product2);

		session2.beginTransaction().commit();

	}

}
