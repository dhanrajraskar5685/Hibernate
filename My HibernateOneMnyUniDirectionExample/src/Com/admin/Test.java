package Com.admin;

import java.util.Scanner;

import Com.Service.OperationImpl;
import Com.Service.OperationInterface;

public class Test {

	public static void main(String[] args) {

		OperationInterface op = new OperationImpl();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			System.out.println("A. Add Customer with Multiple Product");
			System.out.println("B. Show All Customer");
			System.out.println("C. Get Single Customer");
			System.out.println("D. Update Customer");
			System.out.println("E. Update Perticular Product Using Customer");
			System.out.println("F. Delete Perticular Product Using Customer");
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			String ch = sc.next();

			switch (ch) {
			case "A":
				op.addCustmoreWithmultipleProduct();
				break;
			case "B":
				op.ShowAllCustomer();
				break;
			case "C":
				op.getsingleCustomer();
				break;
			case "D":
				op.updateCustomer();
				break;
			case "E":
				op.updatePerticularProductUsingCustomer();
				break;
			case "F":
				op.deletePerticularProductUsingCustomer();
				break;
			default:
				break;
			}
		}

	}

}
