package com.admin;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Model.Product;
import com.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Product product = new Product();
//		product.setPid(5);
//		product.setName("laptop");
//		product.setPtype("electronic");
//		product.setPrice(36000);
//
//		session.save(product);
//		session.beginTransaction().commit();

		// select * from product
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);

		Root<Product> root = criteriaQuery.from(Product.class);
		criteriaQuery.select(root);

		Query query = session.createQuery(criteriaQuery);
		List<Product> list = query.getResultList();
		System.out.println(list);
		System.out.println("+++++++++++++++++++++++++++++");

		// select * from product where pid
		CriteriaBuilder builder1 = session.getCriteriaBuilder();
		CriteriaQuery<Product> cQuery = builder1.createQuery(Product.class);
		Root<Product> root1 = cQuery.from(Product.class);
		criteriaQuery.select(root1).where(builder1.equal(root1.get("pid"), 3));
		Query query1 = session.createQuery(cQuery);
		List<Product> list1 = query1.getResultList();
		System.out.println(list1);
		System.out.println("+++++++++++++++++++++++++++++");
		// select name from product

		CriteriaBuilder builder2 = session.getCriteriaBuilder();
		CriteriaQuery<String> cQuery2 = builder2.createQuery(String.class);
		Root<Product> root2 = cQuery2.from(Product.class);
		cQuery2.select(root2.get("name"));
		Query query2 = session.createQuery(cQuery2);
		List<Product> list2 = query2.getResultList();
		System.out.println(list2);
		System.out.println("+++++++++++++++++++++++++++++");

		// select name,ptype,price from Product

		CriteriaBuilder builder3 = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> cQuery3 = builder3.createQuery(Object[].class);
		Root<Product> root3 = cQuery3.from(Product.class);
		cQuery3.multiselect(root3.get("name"), root3.get("ptype"), root3.get("price"));
		Query query3 = session.createQuery(cQuery3);
		List<Object[]> list3 = query3.getResultList();
		for (Object[] o : list3) {
			System.out.println("Name:" + o[0]);

			System.out.println("ptype:" + o[1]);

			System.out.println("price:" + o[2]);
			System.out.println("+++++++++++++");
		}
	}

}
