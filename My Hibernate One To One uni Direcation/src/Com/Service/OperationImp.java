package Com.Service;

import java.util.List;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Com.Model.Aadharcard;
import Com.Model.Person;
import Com.Util.HibernateUtil;

public class OperationImp implements Operation {

	SessionFactory sf = HibernateUtil.getsSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addPersonWithAadarcardData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Person person = new Person();
		Aadharcard aadharcard = new Aadharcard();

		System.out.println("Enter Person Name: ");
		person.setPname(sc.next());

		System.out.println("Enter Person Address: ");
		person.setAddress(sc.next());

		System.out.println("Enter Aadarcard no");
		aadharcard.setAno(sc.nextLong());

		System.out.println("Enter Officer Name: ");
		aadharcard.setNameofOfficer(sc.next());

		person.setAadharcard(aadharcard);
		session.save(person);
//		Transaction tx = session.beginTransaction();
//		tx.commit();
		session.beginTransaction().commit();
		System.out.println("Data added");
	}

	@Override
	public void showAllPersonDeta() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Query<Person> query = session.createQuery("from Person");
		List<Person> plist = query.getResultList();

		System.out.println(plist);
	}

	@Override
	public void getSinglePesonData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println(" Enter Person id ");
		int id = sc.nextInt();
		Person person = session.get(Person.class, id);
		
		if (person != null) {
			System.out.println(person);
		} else {
			System.out.println("Person Id not found");
		}
	}

	@Override
	public void updatePersonData() {
		Session session = sf.openSession();

		System.out.println("Enter  Perosn Id : ");
		int id = sc.nextInt();
		Person person = session.get(Person.class, id);
		if (person != null) {

			System.out.println("Enter Person Name : ");
			person.setPname(sc.next());

			System.out.println("Enter Person Address  :  ");
			person.setAddress(sc.next());

			session.update(person);
			session.beginTransaction().commit();

		} else {
			System.out.println("Person Id not found");
		}
	}

	@Override
	public void updateAadarcardData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		showAllPersonDeta();

		System.out.println("Enter person Id to update details: ");
		int id = sc.nextInt();
		Person person1 = session.get(Person.class, id);
		if (person1 != null) {

			System.out.println("Save Record of this Person: " + person1);

			System.out.println("Update Aadhar NO");
			person1.getAadharcard().setAno(sc.nextInt());

			System.out.println("Update Name of Officer");
			person1.getAadharcard().setNameofOfficer(sc.next());

			session.update(person1);
			session.beginTransaction().commit();
			System.out.println("Aadhar Data Updated");

		} else {
			System.out.println("Person Id not found");

		}

	}

	@Override
	public void deletePerson() {

		Session session = sf.openSession();
		showAllPersonDeta();
		System.out.println("Enter person Id to Delete");
		int id = sc.nextInt();
		Person person2 = session.get(Person.class, id);
		if (person2 != null) {
			//System.out.println(person2);
			session.delete(person2);
			session.beginTransaction().commit();
			System.out.println("Person Delete Sucessfully");

		} else {
			System.out.println("Person Id not found");

		}
	}

}
