package com.guice.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guice.example.service.Student;

@WebServlet("/saveServlet")
public class SaveStudentData extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");  
        PrintWriter out=resp.getWriter();          
        String name=req.getParameter("sname");  
        Student s = new Student();
        s.setName(name);
        out.print("<p>Record saved successfully!</p>");  
        req.getRequestDispatcher("view.jsp").include(req, resp);  
        out.close();  
	}
}
