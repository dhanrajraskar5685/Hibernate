package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Model.College;
import com.Model.Student;
import com.Util.HibernateUtil;

public class OperationImpl implements OperationService {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addStudentWithCollege() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		Student student = new Student();
		College college = new College();

		System.out.println("Enter Student Name");
		student.setName(sc.next());

		System.out.println("Enter Student Address");
		student.setAddress(sc.next());

		System.out.println("Enter College Name");
		college.setCname(sc.next());

		student.setCollege(college);
		college.setStudent(student);

		session.save(college);
		session.save(student);

		session.beginTransaction().commit();

	}

	@Override
	public void showAllStudentData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student");
		System.out.println(query.getResultList());

	}

	@Override
	public void addCollegeWithStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		College college = new College();
		Student student = new Student();

		System.out.println("Enter College Name");
		college.setCname(sc.next());

		System.out.println("Enter Student Name");
		student.setName(sc.next());

		System.out.println("Enter Student Address");
		student.setAddress(sc.next());

		student.setCollege(college);
		college.setStudent(student);

		session.save(student);
		session.save(college);

		session.beginTransaction().commit();
		System.out.println("Data Saved!!!");

	}

	@Override
	public void showCollegeData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Query<College> query = session.createQuery("from College");
		List<College> clist = query.getResultList();
		for (College c : clist) {
			System.out.println(c.getCid());
			System.out.println(c.getCname());
			System.out.println(c.getStudent().getSid());
			System.out.println(c.getStudent().getName());
			System.out.println(c.getStudent().getAddress());
		}

	}

	@Override
	public void getSingleStudentDataBySid() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		showAllStudentData();
		System.out.println("Enter Student Id");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Student Id not found");
		}

	}

	@Override
	public void updteStudentDataBySid() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		showAllStudentData();
		System.out.println("---------------------------------");
		System.out.println("Enter Student Id to update details : ");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);
		if (student != null) {
			System.out.println("Saved Record of this Student : " + student);

			System.out.println("Update Student Name");
			student.setName(sc.next());

			System.out.println("Update Student Address");
			student.setAddress(sc.next());

			session.update(student);
			session.beginTransaction().commit();
			System.out.println("Data Updated!!! ");

		} else {
			System.out.println("Student Id not found");
		}

	}

	@Override
	public void updateCollegeDataBySid() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		showAllStudentData();
		System.out.println("-----------------------------------");
		System.out.println("Enter student Id to update details : ");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);
		if (student != null) {
			System.out.println("Saved Record of this Student : " + student);

			System.out.println("Update College Name");
			student.getCollege().setCname(sc.next());

			session.update(student);
			session.beginTransaction().commit();
			System.out.println("College Data Updated!!! ");
		} else {
			System.out.println("Student Id not found");
		}

	}

	@Override
	public void deleteStudentBySid() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		showAllStudentData();
		System.out.println("Enter Student Id to delete data : ");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);
		if (student != null) {
			System.out.println("Saved Record of this Student : " + student);

			session.delete(student);

			session.beginTransaction().commit();
			System.out.println("Data Deleted!!!");

		} else {
			System.out.println("Student Id not found");
		}

	}

	@Override
	public void getSingleCollegeDataByCid() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		showCollegeData();
		System.out.println("Enter College Id");
		int id = sc.nextInt();
		College college = session.get(College.class, id);
		if (college != null) {
			System.out.println(college + " " + "Sid:" + " " + college.getStudent().getSid() + " " + "Sname:" + " "
					+ college.getStudent().getName() + " " + "Saddress" + " " + college.getStudent().getAddress());
		} else {
			System.out.println("College Id not found");
		}

	}

	@Override
	public void updteCollegeDataByCid() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		showCollegeData();
		System.out.println("-----------------------------------");
		System.out.println("Enter College Id to update details : ");
		int id = sc.nextInt();
		College college = session.get(College.class, id);
		if (college != null) {
			System.out.println("Saved Record of this College : " + college);

			System.out.println("Update College Name");
			college.setCname(sc.next());

			session.update(college);
			session.beginTransaction().commit();
			System.out.println("College Data Updated!!! ");
		} else {
			System.out.println("College Id not found");
		}

	}

	@Override
	public void updateStudentDataByCid() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		showCollegeData();
		System.out.println("---------------------------------");
		System.out.println("Enter College Id to update details : ");
		int id = sc.nextInt();
		College college = session.get(College.class, id);
		if (college != null) {
			System.out.println("Saved Record of this Student : " + college);

			System.out.println("Update Student Name");
			college.getStudent().setName(sc.next());

			System.out.println("Update Student Address");
			college.getStudent().setAddress(sc.next());

			session.update(college);
			session.beginTransaction().commit();
			System.out.println("Data Updated!!! ");

		} else {
			System.out.println("College Id not found");
		}

	}

	@Override
	public void deleteCollegeByCid() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		showCollegeData();
		System.out.println("Enter College Id to delete data : ");
		int id = sc.nextInt();
		College college = session.get(College.class, id);
		if (college != null) {
			System.out.println("Saved Record of this College : " + college);

			session.delete(college);

			session.beginTransaction().commit();
			System.out.println("Data Deleted!!!");

		} else {
			System.out.println("College Id not found");
		}

	}

}
