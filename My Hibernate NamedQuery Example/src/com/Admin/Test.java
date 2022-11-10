package com.Admin;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Model.Student;
import com.Util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

//		Student student1 = new Student();
//		student1.setName("jyotsna");
//		student1.setAddress("pune");
//		session.save(student1);
//		session.beginTransaction().commit();
//		System.out.println("Done>>>>>>>>>>>>>>>>>>>>>");
//		
		Query<Student> query = session.createNamedQuery("all");
		List<Student> elist = query.getResultList();
		System.out.println(elist);
		System.out.println("+++++++++++++++++++++++++++++++++");

		Query<Student> query1 = session.createNamedQuery("singlestudent");
		query1.setParameter("id1", 1);
		Student student2 = query1.getSingleResult();
		System.out.println(student2);

		System.out.println("-------------------------------------");
		session.getTransaction().begin();
		Query<Student> query3 = session.getNamedQuery("updateEmp");
		query3.setParameter("id", 1);
		query3.setParameter("n", "Dhanraj");
		query3.setParameter("ad", "pcmc");

		int i = query3.executeUpdate();
		System.out.println(i);

	}

}
