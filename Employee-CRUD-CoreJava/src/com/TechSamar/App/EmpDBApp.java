package com.TechSamar.App;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.TechSamar.Employee.Employee;
import com.TechSamar.dao.EmployeeDAO;
import com.TechSamar.dao.EmployeeDAOImpl;

public class EmpDBApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int id;
		String name;
		String option;

		EmployeeDAO dao = new EmployeeDAOImpl();

		System.out.println("*****Welcome to Employee Managemanent Application*****");

		while (true) {
			System.out.println("\n1.Add new Employee" + "\n2.Show All Employee" + "\n3.Show Employee by ID"
					+ "\n4.To update Employee details" + "\n5.To delete Employee");
			System.out.println("\nEnter your choice :-");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				Employee emp = new Employee();
				do {
					try {
						System.out.println("Enter Employee ID :");
						id = sc.nextInt();
						System.out.println("Enter Employee Name :");
						name = sc.next();

						System.out.println("Enter Employee Salary :");
						double salary = sc.nextDouble();

						System.out.println("Enter Employee age :");
						int age = sc.nextInt();

						System.out.println("Enter Employee city:");
						String city = sc.next();

						// to set all fields of dao class
						emp.setId(id);
						emp.setName(name);
						emp.setSalary(salary);
						emp.setAge(age);
						emp.setAddress(city);
						dao.createEmployee(emp);
					} catch (InputMismatchException ie) {
						System.out.println("Invalid input...");
						break;
					}

					System.out.println("\nDo you want to add another employee [Yes/No] ?");
					option = sc.next();
				} while (option.equalsIgnoreCase("yes"));
				break;

			case 2:
				dao.showAllEmployee();
				break;
			case 3:
				while (true) {
					try {
						System.out.println("\nEnter Employee Id :-");

						id = sc.nextInt();
						dao.showEmployeeById(id);
					} catch (InputMismatchException ie) {
						System.out.println("Invalid input...");
						break;
					}

					System.out.println("\nDo you want to see another employee [Yes/No] ?");
					option = sc.next();
					if (option.equalsIgnoreCase("no")) {
						break;
					}
				}
				break;

			case 4:
				while (true) {
					System.out.println("Enter Employee Id to update details :-");

					id = sc.nextInt();

					System.out.println("Enter name :-");

					name = sc.next();
					dao.updateEmployee(id, name);

					System.out.println("\nDo you want to update another employee [Yes/No] ?");
					option = sc.next();
					if (option.equalsIgnoreCase("no")) {
						break;
					}
				}
				break;

			case 5:
				while (true) {
					try {
						System.out.println("Enter Employee Id for delete :-");
						id = sc.nextInt();
					} catch (InputMismatchException ie) {
						System.out.println("Invalid input...");
						break;
					}
					dao.deleteEmployee(id);
					System.out.println("\nDo you want to delete another employee [Yes/No] ?");
					option = sc.next();
					if (option.equalsIgnoreCase("no")) {
						break;
					}
				}
				break;

			default:
				System.out.println("Please,Enter a valid Choice !");
			}
			System.out.println("...............................................");
			System.out.println("\nDo you want to continue [Yes/No] ?");
			option = sc.next();
			if (option.equalsIgnoreCase("no")) {
				System.out.println("Thank You ! Visit Again !");
				break;
			}
		}

	}

}
