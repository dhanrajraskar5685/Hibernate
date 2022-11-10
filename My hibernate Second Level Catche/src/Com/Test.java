package Com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSesionFactory();
		Session session = sf.openSession();
		product product = new product();
//		product.setPid(102);
//		product.setPname("book");
//		product.setPrice("3000");
//		session.save(product);
//		session.beginTransaction().commit();
		
		product product1 =  session.get(product.class, 1);
		System.out.println(product1);
		System.out.println("+++++++++++++++++++++++++++");
		Session session1 = sf.openSession();
		product product2 =  session1.get(product.class, 1);
		System.out.println(product2);
		
	}

}
