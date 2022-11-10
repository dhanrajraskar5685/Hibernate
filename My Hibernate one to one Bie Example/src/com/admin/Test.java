package com.admin;

import java.util.Scanner;

import com.Service.OperationImpl;
import com.Service.OperationService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperationService op = new OperationImpl();
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println("1. Add Student With College Data");
			System.out.println("2. Show All Student Data with College Data");
			System.out.println("3. Add College Data With Student Data");
			System.out.println("4. Show All College Data With Student");
			System.out.println("5. Get Single Student Data By Sid");
			System.out.println("6. Updte Student Data By Sid");
			System.out.println("7. Update College Data By Sid");
			System.out.println("8. Delete Student By Sid");
			System.out.println("9. Show All College Data With Student");
			System.out.println("10.Get Single College Data By Cid");
			System.out.println("11.Update Student Data By Cid");
			System.out.println("12.Delete College By Cid");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				op.addStudentWithCollege();
				break;

			case 2:
				op.showAllStudentData();
				break;

			case 3:
				op.addCollegeWithStudent();
				break;

			case 4:
				op.showCollegeData();
				break;
			case 5:
				op.getSingleStudentDataBySid();
				break;

			case 6:
				op.updteStudentDataBySid();
				break;

			case 7:
				op.updateCollegeDataBySid();
				break;

			case 8:
				op.deleteStudentBySid();
				break;

			case 9:
				op.getSingleCollegeDataByCid();
				break;

			case 10:
				op.updteCollegeDataByCid();
				break;

			case 11:
				op.updateStudentDataByCid();
				break;

			case 12:
				op.deleteCollegeByCid();
				break;

			default:
				break;

			}
		}
	}
}
