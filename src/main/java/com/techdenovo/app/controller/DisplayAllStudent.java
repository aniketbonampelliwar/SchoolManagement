package com.techdenovo.app.controller;

import com.techdenovo.app.dao.StudentDao;
import com.techdenovo.app.model.Student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studentlist")
public class DisplayAllStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	StudentDao studentDao = new StudentDao();
        List<Student> studentList = studentDao.displayAllstudents();
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("/studentlist.jsp").forward(request, response);
//        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request, response);
    }
}
