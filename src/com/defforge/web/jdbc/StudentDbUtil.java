package com.defforge.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;


public class StudentDbUtil {
	
	private DataSource dataSource;
	
	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if(myStmt != null)
				myStmt.close();
			if(myRs != null)
				myRs.close();
			if(myConn != null)
				myConn.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Student> getStudents() throws Exception{
		List<Student> students = new ArrayList<Student>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			myStmt = myConn.createStatement();
			String sql = "select * from student order by last_name";
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				Student tempStudent = new Student(id, firstName, lastName, email);
				students.add(tempStudent);
			}
			return students;
		}
		finally {
			close(myConn, myStmt, myRs);
		}
	}
			
	public boolean CreateStudent(Student student)
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			myStmt = myConn.prepareStatement("INSERT INTO student (last_name, first_name, email) VALUES(?, ?, ?);");
			myStmt.setString(1, student.getLastName());
			myStmt.setString(2, student.getFirstName());
			myStmt.setString(3, student.getEmail());
			myStmt.executeUpdate();
			return true;			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			close(myConn, myStmt, null);
		}
	}
	
	public Student fetchStudent(int id) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		Student student = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM student WHERE id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			myRs = myStmt.executeQuery();
			
			while(myRs.next()) {	
				student = new Student(id, myRs.getString("first_name"),  myRs.getString("last_name"), myRs.getString("email"));
			}
			return student;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		finally {
			close(myConn, myStmt, myRs);
		}
	}
	
	public void updateStudent(Student student) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "UPDATE student SET first_name=?, last_name=?, email=?  where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, student.getFirstName());
			myStmt.setString(2, student.getLastName());
			myStmt.setString(3, student.getEmail());
			myStmt.setInt(4, student.getId());
			myStmt.execute();		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			close(myConn, myStmt, null);
		}
	}
	
	public void deleteStudent(int id) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "DELETE FROM student WHERE id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			myStmt.execute();		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			close(myConn, myStmt, null);
		}		
	}
}
