package Com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Com.Model.Student;
import Com.Model.subject;
import Com.Util.HibernateUtil;

public class OperationImp implements OperationInterface {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addStudentWithmultipleSubject() {
		Session session = sf.openSession();
		Student student = new Student();
		System.out.println("Enter Student Name: ");
		student.setSname(sc.next());

		System.out.println("Enter Student Address: ");
		student.setSaddress(sc.next());

		System.out.println("How Many Subject to be Add: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			subject subject = new subject();

			System.out.println("Enter Subject name: ");
			subject.setSubname(sc.next());

			student.getSlist().add(subject);
			subject.setStudent(student);
			session.save(student);
			session.save(subject);
		}

		session.beginTransaction().commit();
	}

	@Override
	public void ShowAllStudentDataWithmultipleSubject() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student");
		List<Student> slist = query.getResultList();
		System.out.println(slist);

	}

	@Override
	public void getsingleStudentDataWithmultipleSubject() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Student id");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);

		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println(" Student  Id not found");
		}
	}

	@Override
	public void updateStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		ShowAllStudentDataWithmultipleSubject();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Enter Student id");
		int id = sc.nextInt();

		Student student = session.get(Student.class, id);
		System.out.println(student);
		if (student != null) {
			System.out.println("Enter update  Student Name: ");
			student.setSname(sc.next());

			System.out.println("Enter update  Student Address: ");
			student.setSaddress(sc.next());

			session.update(student);
			session.beginTransaction().commit();

			System.out.println("Data Updated!!! ");

		} else {
			System.out.println("Student Id not found");
		}
	}

	@Override
	public void updatePerticularSubjectUsingStudentId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		ShowAllStudentDataWithmultipleSubject();
		
		System.out.println("Enter Student id: ");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);
		
		subject subject = null;
		boolean flag = false;

		if (student != null) {
			System.out.println(student);
			List<subject> slist = student.getSlist();
			
			System.out.println("Enter Subject id: ");
			int Id = sc.nextInt();
			
			for (subject subject2 : slist) {
				if (subject2.getSubid() == Id) {
					subject = subject2;
					flag = true;
					break;
				}
			}

			if (true) {
				System.out.println("Enter update Subject Name:");
				subject.setSubname(sc.next());
				student.getSlist().add(subject);
				session.update(student);
				session.beginTransaction().commit();
			}
		}

		else {
			System.out.println("Student Id not found");
		}
	}

	@Override
	public void deleteStudent() {
		Session session = sf.openSession();
		ShowAllStudentDataWithmultipleSubject();
		
		System.out.println("Enter Student id: ");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);
		
		subject subject = null;
		boolean flag = false;

		if (student != null) {
			System.out.println(student);
			List<subject> slist = student.getSlist();
			System.out.println("Enter Subject id: ");

			int Id = sc.nextInt();
			for (subject subject2 : slist) {
				if (subject2.getSubid() == Id) {
					subject = subject2;
					flag = true;
					break;

				}

			}
			if (true) {
				slist.remove(subject);
				student.setSlist(slist);
				session.update(student);
				session.beginTransaction().commit();
				System.out.println("Subject Deleted >>");
			}
		} else {
			System.out.println("Student Id not found");
		}

	}

	@Override
	public void addMultipleSubjectToSingleStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ShowAllSubjectWithStudentData() {

		Session session = sf.openSession();
		Query<subject> query = session.createQuery("from subject");
		List<subject> slist = query.getResultList();
		for (subject s : slist) {
			System.out.println(s.getSubid());
			System.out.println(s.getSubname());
			System.out.println(s.getStudent().getPid());
			System.out.println(s.getStudent().getSname());
			System.out.println(s.getStudent().getSaddress());
		}
	}

	@Override
	public void getsingleSubjectWithStudentData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Subject id");
		int id = sc.nextInt();
		subject subject = session.get(subject.class, id);

		if (subject != null) {
			System.out.println(subject);
		} else {
			System.out.println(" Subject  Id not found");
		}
	}

	@Override
	public void updateSubject() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		ShowAllSubjectWithStudentData();
		System.out.println("++++++++++++++++++++++");
		System.out.println("Enter Subject id");
		int id = sc.nextInt();
		subject subject = session.get(subject.class, id);
		System.out.println(subject);
		if (subject != null) {

			System.out.println("Enter update  Subject Name: ");
			subject.setSubname(sc.next());

			session.update(subject);
			session.beginTransaction().commit();
			System.out.println(" Subject Data Updated!!! ");

		} else {
			System.out.println("Subject Id not found");
		}
	}

	@Override
	public void updatePerticularStudentUsingSubjectId() {
		Session session = sf.openSession();
		ShowAllSubjectWithStudentData();
		System.out.println("++++++++++++++++++++");
		System.out.println("Enter Subject id");
		int id = sc.nextInt();
		subject subject = session.get(subject.class, id);
		if (subject != null) {
			System.out.println(subject);
			System.out.println("Update Student Name: ");
			
			subject.getStudent().setSname(sc.next());
			System.out.println("Update Student Address");
			
			subject.getStudent().setSaddress(sc.next());

			session.update(subject);
			session.beginTransaction().commit();
			System.out.println("Data Updated!!! ");

		} else {
			System.out.println("Subject Id not found");
		}

	}

	@Override
	public void deleteSubject() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		ShowAllSubjectWithStudentData();
		System.out.println("++++++++++++++++++++");
		System.out.println("Enter Subject id");
		int id = sc.nextInt();
		subject subject = session.get(subject.class, id);
		if (subject != null) {
			System.out.println(subject);
			session.delete(subject);
			session.beginTransaction().commit();
			System.out.println("Data Updated!!! ");

		} else {
			System.out.println("Subject Id not found");
		}

	}

}
