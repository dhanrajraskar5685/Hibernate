package com.Admin;

import java.util.Scanner;

import com.Service.OperationImp;
import com.Service.OperationService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperationService op = new OperationImp();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			System.out.println("1. Add Employee With HrEmployee");
			System.out.println("2. ShowAllEmployee");
			System.out.println("3. Get Single Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Update Perticular HrEmployee Using Eid");
			System.out.println("6. Delete Perticular HrEmployee Using Employee");
			System.out.println("7.Get All Data Of Employee Whose Designation");
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				op.AddEmployeeWithHrEmployee();
				break;
			case 2:
				op.showAllEmployee();
				break;
			case 3:
				op.getSingleEmployee();
				break;
			case 4:
				op.updateEmployee();
				break;
			case 5:
				op.updatePerticularHrUsingEid();
				break;
			case 6:
				op.deletePerticularHrEmployeeusingEmployee();
				break;
			case 7:
				op.getAllDataOfEmployeeWhoseDesignation();
				break;
			default:

			}
		}

	}
}