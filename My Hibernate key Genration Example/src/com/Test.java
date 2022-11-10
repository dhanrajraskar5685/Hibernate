package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Student student = new Student();
		student.setSid(101);
		student.setName("Dhanraj");
		student.setAddress("pune");

		College college = new College();
		college.setCid(1111);
		college.setCname("MIT");
		college.setCcode("Mit123");

		Student student1 = new Student();
		student1.setSid(101);
		student1.setName("Dhanraj");
		student1.setAddress("pune");

		session.save(college);
		session.save(student);
		session.save(student1);
		session.beginTransaction().commit();

	}

}
