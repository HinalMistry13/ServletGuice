package com.guice.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.guice.example.service.Student;
import com.guice.example.service.StudentService;

@Singleton
@WebServlet("/ViewServlet")
public class ViewStudentData extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StudentService studentService;

	@Inject
	public ViewStudentData(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		List<Student> students = studentService.getStudents();
		req.setAttribute("studentList", students);
		req.getRequestDispatcher("view.jsp").forward(req, resp);
	}

}
