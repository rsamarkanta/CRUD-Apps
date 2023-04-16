package com.ts.crud;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ts.entities.Employee;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();

		System.out.println("*****Welcome to Employee Managemanent Application*****");

		System.out.println("\n1.Add new Employee" + "\n2.Show All Employee" + "\n3.Show Employee by ID"
				+ "\n4.To update Employee details" + "\n5.To delete Employee");
		System.out.print("\nEnter your choice : ");

		Employee employee = new Employee();

		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();

		// Declaring variable
		Integer id;
		String name;
		Double salary;
		String mail;

		switch (choice) {
		case 1:

			System.out.println("Enter Employee Name :");
			name = sc.next();

			System.out.println("Enter Employee mail :");
			mail = sc.next();

			System.out.println("Enter Employee Salary :");
			salary = sc.nextDouble();

			// to set all fields of Employee
			employee.setName(name);
			employee.setSalary(salary);
			employee.setMail(mail);

			tx.begin();
			// save
			session.save(employee);
			tx.commit();

			System.out.println("Employee added successfully...");
			session.close();

			break;

		case 2:
			tx = session.beginTransaction();

			String hql = "from Employee";

			TypedQuery<Employee> query = session.createQuery(hql);

			// retrieve data and save to the list
			List<Employee> emp = query.getResultList();

			Iterator<Employee> iterator = emp.iterator();

			// iterate list
			while (iterator.hasNext()) {
				Employee empl = iterator.next();
				System.out.println("Employee Id : " + empl.getId() + " | mail : " + empl.getMail() + " | name : "
						+ empl.getName() + " | salary : " + empl.getSalary());
			}

			break;

		case 3:
			System.out.println("\nEnter Employee Id :-");

			id = sc.nextInt();

			tx.begin();
			// retrieve data by id
			employee = session.get(Employee.class, id);

			// check if employee is found or not
			if (employee == null) {
				System.out.println("No Employee Id found...");
			} else {

				System.out.println("name : " + employee.getName());
				System.out.println("mail : " + employee.getMail());
				System.out.println("salary : " + employee.getSalary());

				tx.commit();
			}
			break;

		case 4:

			System.out.println("Enter Employee Id to update details :-");

			id = sc.nextInt();

			tx.begin();

			// get employee object
			employee = session.get(Employee.class, id);

			// check employee id is found or not
			if (employee == null) {
				System.out.println("No Employee Id found...");
			} else {

				System.out.println("Enter name :-");

				name = sc.next();

				System.out.println("Enter mail :-");

				mail = sc.next();

				System.out.println("Enter Salary :-");

				salary = sc.nextDouble();

				// set data for update
				employee.setName(name);
				employee.setMail(mail);
				employee.setSalary(salary);

				// update
				session.saveOrUpdate(employee);

				tx.commit();
				System.out.println("Employee updated successfully...");
			}
			break;

		case 5:
			System.out.println("Enter Employee Id for delete :-");
			id = sc.nextInt();

			// get employee object
			employee = session.get(Employee.class, id);

			// check the employee id is found or not
			if (employee == null) {
				System.out.println("No Employee Id found...");
			} else {
				tx.begin();

				// delete
				session.delete(employee);

				tx.commit();
				System.out.println("Employee deleted successfully...");

			}

			break;

		default:
			System.out.println("Please,Enter a valid Choice !");

		}
		session.close();
	}
}
