package Com.Controller;

import java.util.Scanner;

import Com.Service.Operation;
import Com.Service.OperationImp;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Operation op = new OperationImp();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("=====================================");
			System.out.println("1.Add Person with AadharCard Data ");
			System.out.println("2.Show All Table Data ");
			System.out.println("3.Get Single Person Data Using Person Id ");
			System.out.println("4.Update Only Person Data");
			System.out.println("5.Update  AadharCard Data Using Person Id");
			System.out.println("6.Delete Person Data");

			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				op.addPersonWithAadarcardData();
				break;
			case 2:
				op.showAllPersonDeta();
				break;
			case 3:
				op.getSinglePesonData();
				break;
			case 4:
				op.updatePersonData();
				break;
			case 5:
				op.updateAadarcardData();
				break;
			case 6:
				op.deletePerson();
				break;
			default:
				break;
			}

		}

	}

}
