package Com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Com.Model.Customer;
import Com.Model.Product;
import Com.Util.HibernateUtil;

public class OperationImpl implements OperationInterface {
	SessionFactory sf = HibernateUtil.getseFactory();

	Scanner sc = new Scanner(System.in);

	@Override
	public void addCustmoreWithmultipleProduct() {
		Customer customer = new Customer();
		System.out.println("Enter Customer Name:");
		customer.setCname(sc.next());
		System.out.println("Enter Customer Address:");
		
		System.out.println("How Many Product to  be buy :");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			Product product = new Product();
			System.out.println("Enter Product name:");

			product.setPname(sc.next());
			System.out.println("Enter Product Price:");
			product.setPrice(sc.nextDouble());
			customer.getPlist().add(product);
		}
		Session session = sf.openSession();
		session.save(customer);
		session.beginTransaction().commit();
	}

	@Override
	public void ShowAllCustomer() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		Query<Customer> query = session.createQuery("from Customer");

		List<Customer> plist = query.getResultList();
		System.out.println(plist);
	}

	@Override
	public void getsingleCustomer() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Customer id");
		int id = sc.nextInt();
		Customer customer = session.get(Customer.class, id);

		if (customer != null) {
			System.out.println(customer);
		} else {
			System.out.println("Customer Id not found");
		}
	}

	@Override
	public void updateCustomer() {
		Session session = sf.openSession();
		System.out.println("Enter Customer id");
		int id = sc.nextInt();
		Customer customer = session.get(Customer.class, id);
		System.out.println(customer);
		if (customer != null) {
			System.out.println("Enter Customer Name:");
			customer.setCname(sc.next());
			session.update(customer);
			session.beginTransaction().commit();
			System.out.println("Data Updated!!! ");

		} else {
			System.out.println("Customer Id not found");
		}
	}

	@Override
	public void updatePerticularProductUsingCustomer() {
		Session session = sf.openSession();
		System.out.println("Enter Customer Id: ");
		int Id = sc.nextInt();
		Customer customer = session.get(Customer.class, Id);

		Product product = null;
		boolean flag = false;

		if (customer != null) {
			System.out.println(customer);
			List<Product> plist = customer.getPlist();
			System.out.println("Enter Product Id: ");
			int pid = sc.nextInt();
			for (Product p : plist) {
				if (p.getPid() == pid) {
					product = p;
					flag = true;
					break;

				}

			}
			if (true) {

				System.out.println("Enter Product Name: ");
				product.setPname(sc.next());
				System.out.println("Enter Product Price: ");
				product.setPrice(sc.nextDouble());

				customer.getPlist().add(product);
				session.update(customer);
				session.beginTransaction().commit();

			}
		} else {
			System.out.println("Customer Not Found");
		}
	}

	@Override
	public void deletePerticularProductUsingCustomer() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Customer Id: ");
		int Id = sc.nextInt();
		Customer customer = session.get(Customer.class, Id);
		Product product = null;
		boolean flag = false;

		if (customer != null) {
			System.out.println(customer);
			List<Product> plist = customer.getPlist();
			System.out.println("Enter Product Id: ");
			int pid = sc.nextInt();
			for (Product p : plist) {
				if (p.getPid() == pid) {
					product = p;
					flag = true;
					break;
				}
			}
			if (true) {

				plist.remove(product);
				customer.setPlist(plist);

				session.update(customer);
				session.delete(product);
				session.beginTransaction().commit();

			}
		} else {
			System.out.println("Customer Not Found");
		}
	}
}
