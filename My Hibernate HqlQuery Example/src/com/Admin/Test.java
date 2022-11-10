package com.Admin;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Model.Employee;
import com.Util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
//		Employee employee = new Employee();
//
//		employee.setName("Saraj");
//		employee.setDesignation("ac");
//		employee.setSalary(690000);
//
//		Date date = new Date(System.currentTimeMillis());
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:sss");
//
//		String joinDate = simpleDateFormat.format(date);
//		System.out.println(joinDate);
//		employee.setJoindate(joinDate);
//		session.save(employee);
//		session.beginTransaction().commit();
//		System.out.println("Done");

		// select from employee
		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> elist = query.getResultList();
		System.out.println(elist);
		System.out.println("======================================================");

// select from Employee Where employee id
		Query<Employee> query1 = session.createQuery("from Employee where id= :Myid");
		query1.setParameter("Myid", 1);
		System.out.println(query1.getSingleResult());
		System.out.println("======================================================");

		// update Employee set name=?, setDesignation=? salary=?;
		Session session1 = sf.openSession();
		session1.beginTransaction();
		Query<Employee> query2 = session1
				.createQuery("update from Employee set name= :n,designation= :D,salary= :s where eid= :myid");
		query2.setParameter("n", "akshay");
		query2.setParameter("D", "teacher");

		query2.setParameter("s", 45000.0);
		query2.setParameter("myid", 1);
		query2.executeUpdate();
		session1.getTransaction().commit();
		System.out.println("======================================================");

		// delete from Employee where id=?

		Session session2 = sf.openSession();
		session2.beginTransaction();
		Query<Employee> query3 = session2.createQuery("delete from Employee  where eid= :myid");
		query3.setParameter("myid", 2);
		query3.executeUpdate();
		session2.getTransaction().commit();
		System.out.println("======================================================");

		// select from max salary from Employee

		Session session3 = sf.openSession();

		Query<Double> query4 = session3.createQuery("select max(salary) from Employee");
		System.out.println(query4.getSingleResult());
		System.out.println("======================================================");

		// select from min salary from Employee
		Session session4 = sf.openSession();
		Query<Double> query5 = session4.createQuery("select min(salary) from Employee");
		System.out.println(query5.getSingleResult());
		System.out.println("======================================================");

		// select from sum salary from Employee
		Session session5 = sf.openSession();
		Query<Double> query6 = session5.createQuery("select sum(salary) from Employee");
		System.out.println(query6.getSingleResult());
		System.out.println("======================================================");

		// select from avg salary from Employee
		Session session6 = sf.openSession();
		Query<Double> query7 = session6.createQuery("select avg(salary) from Employee");
		System.out.println(query7.getSingleResult());
		System.out.println("======================================================");

		// select count(*) from Employee
		Session session7 = sf.openSession();
		Query<Double> query8 = session7.createQuery("select count(*)  from Employee");
		System.out.println(query8.getSingleResult());
		System.out.println("======================================================");

		// select from second max salary from Employee
		Session session8 = sf.openSession();
		Query<Double> query9 = session8
				.createQuery("select max(salary) from Employee where salary < (select max(salary) from Employee)");
		System.out.println(query9.getSingleResult());
		System.out.println("======================================================");

		// N th highest Salary Find Out sql Query
				//select name,address from employee e1 where 
				//N-1 = (select count(distinct salary) from employee e2 where e2.salary > e1.salary);
		
	}

}
