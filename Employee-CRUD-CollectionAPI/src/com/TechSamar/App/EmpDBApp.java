package com.TechSamar.App;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.TechSamar.employee.Employee;

public class EmpDBApp {

	public static void main(String[] args) {
		// Store data using ArrayList
		List<Employee> c = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);

		// initialize variable
		int id;
		String name;
		double salary;
		int age;
		String city;
		boolean found;

		System.out.println("*****Welcome to Employee Managemanent Application*****");
		int choice;

		// use try...catch to catch the InputMissMatchException
		try {

			do {
				// display menu
				System.out.println("\n1.Add new Employee" + "\n2.Show All Employee" + "\n3.Show Employee by ID"
						+ "\n4.To update Employee details" + "\n5.delete Employee" + "\n6.EXIT");
				System.out.println("\nEnter your choice :-");
				choice = sc.nextInt();

				switch (choice) {
				// case 1
				case 1:
					// take input to create Employee data
					System.out.println("Enter Employee ID :");
					id = sc.nextInt();

					System.out.println("Enter Employee Name :");
					name = sc.next();

					System.out.println("Enter Employee Salary :");
					salary = sc.nextDouble();

					System.out.println("Enter Employee age :");
					age = sc.nextInt();

					System.out.println("Enter Employee city:");
					city = sc.next();

					c.add(new Employee(id, name, salary, age, city));
					break;
				// case 2
				case 2:

					System.out.println("---------------------------------------------------------------");
					// use iterator to iterate records
					Iterator<Employee> i = c.iterator();

					while (i.hasNext()) {
						Employee e = i.next();
						// print records by using toString() method
						System.out.println(e);
					}

					System.out.println("----------------------------------------------------------------");
					break;

				// case 3
				case 3:

					found = false;
					System.out.println("\nEnter Employee Id :-");
					id = sc.nextInt();
					System.out.println("---------------------------------------------------------------");
					// use iterator to iterate records
					i = c.iterator();
					while (i.hasNext()) {
						Employee e = i.next();
						// check id is available or not
						if (e.getId() == id) {
							// print record
							System.out.println(e);
							found = true;
						}
					}

					if (!found)
						System.out.println("Record not Found !!");
					System.out.println("----------------------------------------------------------------");
					break;

				// case 4
				case 4:
					found = false;
					System.out.println("Enter Employee Id to update details :-");
					id = sc.nextInt();

					System.out.println("---------------------------------------------------------------");
					// use iterator to iterate records
					ListIterator<Employee> li = c.listIterator();
					while (li.hasNext()) {
						Employee e = li.next();
						// check id is matching or not
						if (e.getId() == id) {

							// take inputs for updating records
							System.out.println("Enter name :-");
							name = sc.next();

							System.out.println("Enter Salary :-");
							salary = sc.nextDouble();

							System.out.println("Enter age:-");
							age = sc.nextInt();

							System.out.println("Enter city name :-");
							city = sc.next();

							// update records with new inputs
							li.set(new Employee(id, name, salary, age, city));
							found = true;
						}
					}
					if (!found)
						System.out.println("Record not Found !!");
					else
						System.out.println("Record updated successfully !!");
					System.out.println("----------------------------------------------------------------");
					break;

				// case 5
				case 5:

					found = false;
					System.out.println("Enter Employee Id for delete :-");

					id = sc.nextInt();

					System.out.println("---------------------------------------------------------------");
					// use iterator to iterate records
					i = c.iterator();
					while (i.hasNext()) {
						Employee e = i.next();
						// check id is matching or not
						if (e.getId() == id) {
							// delete record for this id
							i.remove();
							found = true;
						}
					}
					if (!found)
						System.out.println("Record not Found !!");
					else
						System.out.println("Record deleted successfully !!");
					System.out.println("----------------------------------------------------------------");
					break;

				// case 6
				case 6:
					// to exit from application
					System.out.println("Thank You !! Visit Again !!!");
					System.exit(0);

					// default
				default:
					// execute default if no case selected
					System.out.println("Please, Enter a valid Choice !");

				}

			} while (choice != 0);

		} // catch InputMismatchException and print message to user
		catch (InputMismatchException ie) {
			System.out.println("\n You have entered an Invalid input...Relaunch Application Please !");
		}

	}
}
