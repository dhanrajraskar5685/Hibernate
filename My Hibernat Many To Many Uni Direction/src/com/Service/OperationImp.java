package com.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Model.Employee;
import com.Model.HrEmployee;
import com.Util.HibernateUtil;

public class OperationImp implements OperationService {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void AddEmployeeWithHrEmployee() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		List<HrEmployee> hlist = new ArrayList<HrEmployee>();
		Employee employee = new Employee();

		System.out.println("Enter Employee Name: ");
		employee.setEname(sc.next());

		System.out.println("Enter Employee Designation: ");
		employee.setDesignation(sc.next());

		System.out.println("How Many HrEmployee Allocating: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			HrEmployee hrEmployee = new HrEmployee();

			System.out.println("Enter HrEmployee Name: ");
			hrEmployee.setHname(sc.next());

			System.out.println(" Enter HrEmployee Desig..");
			hrEmployee.setHdesignation(sc.next());
			hlist.add(hrEmployee);
		}

		employee.setHrEmployee(hlist);
		session.save(employee);
		session.beginTransaction().commit();
		System.out.println(" Data Added.....");
	}

	@Override
	public void showAllEmployee() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Query<Employee> query = session.createQuery(" from Employee");
		List<Employee> Elist = query.getResultList();
		System.out.println(Elist);
	}

	@Override
	public void getSingleEmployee() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		showAllEmployee();

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

		System.out.println(" Enter Employee Id: ");
		int id = sc.nextInt();

		Employee employee = session.get(Employee.class, id);

		if (employee != null) {
			System.out.println(employee);
		} else {
			System.out.println(" Employee Id not found");
		}
	}

	@Override
	public void updateEmployee() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		showAllEmployee();

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

		System.out.println(" Enter Employee Id: ");
		int id = sc.nextInt();

		Employee employee = session.get(Employee.class, id);
		System.out.println(employee);
		if (employee != null) {
			System.out.println("Enter Updated Employee Name: ");
			employee.setEname(sc.next());

			System.out.println("Enter UpdatedEmployee Designation:");
			employee.setDesignation(sc.next());

			session.update(employee);
			session.beginTransaction().commit();
			System.out.println("Data updated>>>");

		} else {
			System.out.println(" Employee Id not found");
		}
	}

	@Override
	public void updatePerticularHrUsingEid() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		showAllEmployee();

		System.out.println("Enter Employee id: ");
		int id = sc.nextInt();
		Employee employee = session.get(Employee.class, id);

		HrEmployee hremployee = null;
		boolean flag = false;

		if (employee != null) {
			System.out.println(employee);
			List<HrEmployee> hrlist = employee.getHrEmployee();

			System.out.println("Enter HrEmployee id: ");
			int Id = sc.nextInt();

			for (HrEmployee h : hrlist) {

				if (h.getHid() == Id) {
					hremployee = h;

					flag = true;
					break;
				}

			}
			if (true) {
				System.out.println("Enter update  HrEmployee  Name:");
				hremployee.setHname(sc.next());

				System.out.println("Enter update  HrEmployee  Desig..:");
				hremployee.setHdesignation(sc.next());
				employee.getHrEmployee().add(hremployee);
				session.update(employee);
				session.beginTransaction().commit();
			}
		} else {
			System.out.println(" Employee Id not found");
		}
		System.out.println("Updated>>>>>>");
	}

	@Override
	public void deletePerticularHrEmployeeusingEmployee() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		showAllEmployee();

		System.out.println("Enter Employee id: ");
		int id = sc.nextInt();
		Employee employee = session.get(Employee.class, id);

		HrEmployee hremployee = null;
		boolean flag = false;

		if (employee != null) {
			System.out.println(employee);
			List<HrEmployee> hrlist = employee.getHrEmployee();

			System.out.println("Enter HrEmployee id: ");
			int Id = sc.nextInt();

			for (HrEmployee h : hrlist) {

				if (h.getHid() == Id) {
					hremployee = h;

					flag = true;
					break;
				}

			}
			if (true) {
				hrlist.remove(hremployee);
				employee.setHrEmployee(hrlist);

				session.update(employee);
				session.beginTransaction().commit();
			}
		} else {
			System.out.println(" Employee Id not found");
		}
		System.out.println("Deleted >>>>>>");
	}

	@Override
	public void getAllDataOfEmployeeWhoseDesignation() {
		// TODO Auto-generated method stub

	}

}
