package com.techdenovo.app.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techdenovo.app.dao.StudentDao;
import com.techdenovo.app.model.Student;

/**
 * Servlet implementation class Student
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private StudentDao studentDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
	};
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		student.setId( Integer.parseInt(request.getParameter("id"))) ;
		student.setFirstName(request.getParameter("first-name"));
		student.setLastName(request.getParameter("last-name"));
		student.setMotherName(request.getParameter("mother-name"));
		student.setFatherName(request.getParameter("father-name"));
		
		StudentDao studentDao = new StudentDao();
		studentDao.addStudent(student);
		response.sendRedirect("studentlist");
	}
	
}
