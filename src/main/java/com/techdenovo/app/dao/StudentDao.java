package com.techdenovo.app.dao;



import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.techdenovo.app.model.Student;
import com.techdenovo.app.util.DbUtils;

public class StudentDao {
	
	DbUtils dbUtils = new DbUtils();
	//-------------------Create student---------------------------
	public void addStudent(Student student) {
		if(!student.getFirstName().isEmpty() && !student.getLastName().isEmpty()) {
			try {
				
				Connection con = dbUtils.getDbConnection();
				PreparedStatement ps = con.prepareStatement("INSERT INTO student(Id,FirstName,LastName,MotherName,FatherName) values (?,?,?,?,?)");
				ps.setInt(1, student.getId());
				ps.setString(2, student.getFirstName());
				ps.setString(3, student.getLastName());
				ps.setString(4, student.getMotherName());
				ps.setString(5, student.getFatherName());
				int i = ps.executeUpdate();
				
				if(i>0) {
			
					System.out.println("You are sucessfully registered");
				}
				
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	//----------------------Update student------------------------------
	public void updateStudent(Student student){
		
		try {
			Connection con = dbUtils.getDbConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE student SET FirstName = ? ,LastName = ?, MotherName = ?, FatherName = ? WHERE ID = ?");
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getMotherName());
			ps.setString(4, student.getFatherName());
			ps.setInt(5, student.getId());
			ps.executeUpdate();
			int i = ps.executeUpdate();
			 System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	//--------------------Display all students----------------------
	
	public List<Student> displayAllstudents() {
		List<Student> studentList =  new ArrayList<Student>();
		
		try {
			Connection con = dbUtils.getDbConnection();
			String string = "SELECT * FROM student"; 
			PreparedStatement ps = con.prepareStatement(string);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("Id"));
				student.setFirstName(rs.getString("FirstName"));
				student.setLastName(rs.getString("LastName"));
				student.setMotherName(rs.getString("MotherName"));
				student.setFatherName(rs.getString("FatherName"));
				studentList.add(student);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
		return studentList;
	}
	
	//--------------------get student by ID---------------------------
	

	public Student getstudent(int id) {
		Student student = null;
		try {
			Connection con = dbUtils.getDbConnection();
			String string = "SELECT * FROM student where id=?"; 
			PreparedStatement ps = con.prepareStatement(string);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				student = new Student();
				student.setId(rs.getInt("Id"));
				student.setFirstName(rs.getString("FirstName"));
				student.setLastName(rs.getString("LastName"));
				student.setMotherName(rs.getString("MotherName"));
				student.setFatherName(rs.getString("FatherName"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
		return student;
	}
	
//-----------------------Delete student----------------------------
	
	public void deleteStudent(int id) {
	    try {
	        Connection con = dbUtils.getDbConnection();
	        PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE ID = ?");
	        ps.setInt(1, id); 
	        ps.executeUpdate(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	       
	    }
	}

}
