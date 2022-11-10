package Com.Tcs.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Com.Tcs.Model.Country;
import Com.Tcs.Util.HibernateUtil;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		Country country = new Country();
		country.setCid(101);
		country.setCname("pune");
		country.setCode("11236");

		session.save(country);
		session.beginTransaction().commit();
		System.out.println("Done");

	}

}
