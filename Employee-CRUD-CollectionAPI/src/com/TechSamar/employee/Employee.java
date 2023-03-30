package com.TechSamar.employee;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private int age;
	private String address;

	public Employee() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee(int id, String name, double salary, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "ID\t\tName\t\tSalary\t\tAge\t\tCity\n" + id +"   "+ name + "\t\t" + salary + "\t\t" + age + "\t" + address;
	}

}
