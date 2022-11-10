package Com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		
		Configuration cfg= new Configuration().configure("hibernate.cgf.xml");
		SessionFactory sf= cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Student student = new Student();
		student.setSid(1);
		student.setSname("dhanraj");
		session.save(student);
		System.out.println("Done");
		
		 Employee employee = new Employee();
		 employee.setEid(124);
		 employee.setEname("raskar");

		 session.save(employee);
		 session.beginTransaction().commit();
		System.out.println("Done 1");
		
	}

}