package com.techdenovo.app.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techdenovo.app.dao.StudentDao;
import com.techdenovo.app.model.Student;

@WebServlet("/edit")
public class UpdateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    	StudentDao studentDao = new StudentDao();
    	int id = Integer.parseInt(request.getParameter("id"));
    	Student existingStudent = studentDao.getstudent(id);
        request.setAttribute("student", existingStudent);
        request.getRequestDispatcher("/UpdateStudent.jsp").forward(request, response);    
    	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Student student = new Student();
    	 student.setId( Integer.parseInt(request.getParameter("id"))) ;
 		student.setFirstName(request.getParameter("first-name"));
 		student.setLastName(request.getParameter("last-name"));
 		student.setMotherName(request.getParameter("mother-name"));
 		student.setFatherName(request.getParameter("father-name"));
 		
        StudentDao studentDao = new StudentDao();
            studentDao.updateStudent(student);
            response.sendRedirect("studentlist");
            System.out.println("student updated sucessfully......!");
    }
    
    
}
