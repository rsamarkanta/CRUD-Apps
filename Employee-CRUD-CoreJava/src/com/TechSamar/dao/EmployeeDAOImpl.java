package com.TechSamar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.TechSamar.App.DBConnection;
import com.TechSamar.Employee.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	Connection con;

	Scanner sc = new Scanner(System.in);

	int count;

	@Override
	public void createEmployee(Employee emp) {

		con = DBConnection.createDbConnection();

		String query = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)";

		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, emp.getId());
			pstm.setString(2, emp.getName());
			pstm.setDouble(3, emp.getSalary());
			pstm.setInt(4, emp.getAge());
			pstm.setString(5, emp.getAddress());

			count = pstm.executeUpdate();
			if (count != 0) {
				System.out.println("Employee inserted Successfully...");
			}
		} catch (SQLException e) {
			System.out.println("Insertion Failed...Duplicate Id found");
		}
	}

	@Override
	public void showAllEmployee() {
		con = DBConnection.createDbConnection();
		String query = "SELECT * FROM EMPLOYEE";
		try {
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(query);
			System.out.println("ID\tName\tSalary\tAge\tCity");
			System.out.println("---------------------------------------------------------");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3) + "\t" + rs.getInt(4)
						+ "\t" + rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showEmployeeById(int id) {
		con = DBConnection.createDbConnection();

		String query = "SELECT * FROM EMPLOYEE WHERE ID=" + id;

		try {
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(query);
			boolean flag = false;
			System.out.println("ID\tName\tSalary\tAge\tCity");

			System.out.println("----------------------------------------------------");
			while (rs.next()) {
				flag = true;
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3) + "\t" + rs.getInt(4)
						+ "\t" + rs.getString(5));

			}
			if (flag != true) {
				System.out.println("No record found...");
			}
		} catch (InputMismatchException ie) {
			System.out.println("Invalid value entered....Try again...");

		} catch (SQLException e) {
			System.out.println("Insertion Failed...Try Again");
		}
	}

	@Override
	public void updateEmployee(int id, String name) {
		con = DBConnection.createDbConnection();

		String query = "UPDATE EMPLOYEE SET NAME=? WHERE ID=?";

		try {
			int count;
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setInt(2, id);
			count = pst.executeUpdate();
			if (count != 0) {
				System.out.println(count + " row  name Updated for " + id);
			} else
				System.out.println("\nInvalid Id...");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmployee(int id) {
		con = DBConnection.createDbConnection();

		String query = "DELETE FROM EMPLOYEE WHERE ID=?";
		try {
			int count;
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			count = pst.executeUpdate();
			if (count != 0) {
				System.out.println(count + " row  name deleted for " + id);
			} else
				System.out.println("\nInvalid Id...");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
