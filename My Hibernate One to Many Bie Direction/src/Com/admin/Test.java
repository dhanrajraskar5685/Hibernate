package Com.admin;

import java.util.Scanner;

import Com.Service.OperationImp;
import Com.Service.OperationInterface;

public class Test {
	public static void main(String[] args) {

		OperationInterface op = new OperationImp();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			System.out.println("A. Add Student With Multiple Subject");
			System.out.println("B. Show All Student Data With Multiple Subject");
			System.out.println("C. Get Single Student Data With Multiple Subject");
			System.out.println("D. Update Student");
			System.out.println("E. Update Perticular Subject Using Student Id");
			System.out.println("F. Delete Student");
			System.out.println("G. Add Multiple Subject To Single Student");
			System.out.println("H. Show All Subject With Student Data");
			System.out.println("I. Get Single Subject With Student Data");
			System.out.println("J. Update Subject");
			System.out.println("K. Update Perticular Student Using SubjectId");
			System.out.println("L. Delete Subject");
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			String ch = sc.next();

			switch (ch) {
			case "A":
				op.addStudentWithmultipleSubject();
				break;
			case "B":
				op.ShowAllStudentDataWithmultipleSubject();
				break;
			case "C":
				op.getsingleStudentDataWithmultipleSubject();
				break;
			case "D":
				op.updateStudent();
				break;
			case "E":
				op.updatePerticularSubjectUsingStudentId();
				break;
			case "F":
				op.deleteStudent();
				break;
			case "G":
				op.addMultipleSubjectToSingleStudent();
				break;
			case "H":
				op.ShowAllSubjectWithStudentData();
				break;
			case "I":
				op.getsingleSubjectWithStudentData();
				break;
			case "J":
				op.updateSubject();
				break;
			case "K":
				op.updatePerticularStudentUsingSubjectId();
				break;
			case "L":
				op.deleteSubject();
				break;
			default:

			}
		}
	}
}
