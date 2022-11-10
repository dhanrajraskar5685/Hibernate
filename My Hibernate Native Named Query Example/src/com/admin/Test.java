package com.admin;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.model.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Employee employee = new Employee();
//		employee.setEid(3);
//		employee.setEname("par");
//		employee.setAddress("pune");
//		session.save(employee);
//		session.beginTransaction().commit();
		Query query = session.getNamedQuery("insert");
		query.setParameter(1, employee.getEid());
		query.setParameter(2, employee.getEname());
		query.setParameter(3, employee.getAddress());
		query.executeUpdate();
		System.out.println("Done");

		Query query1 = session.createNamedQuery("AllData");
		List<Employee> clist = query1.getResultList();
		System.out.println(clist);

		System.out.println("---------------------------------------------------------");
		Query query2 = session.createNamedQuery("AllDataDesc");
		List<Employee> clist1 = query2.getResultList();
		System.out.println(clist1);

		System.out.println("-----------------------------------------------");

		Query query3 = session.createNamedQuery("updateData");
		query3.setParameter(1, 1);
		query3.setParameter(2, "Hinjewad ph 3");
		query3.setParameter(3, "Congnizant");
		query3.executeUpdate();
		session.getTransaction().commit();
		System.out.println("Done");

	}

}
