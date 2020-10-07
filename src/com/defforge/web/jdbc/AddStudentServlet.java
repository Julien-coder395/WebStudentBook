package com.defforge.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private StudentDbUtil studentDbUtil;
    
    @Resource(name="jdbc/studentdb")
    private DataSource dataSource;
       
	@Override
	public void init() throws ServletException {
		super.init();
		studentDbUtil = new StudentDbUtil(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/add-student.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		Student student = new Student(lastName, firstName, email);
		
		if(studentDbUtil.CreateStudent(student)) {
			request.setAttribute("statusMessage", "The saving is succesful");		
		}
		else {
			request.setAttribute("statusMessage", "Error during the saving");
		}
		response.sendRedirect("StudentControllerServlet");
	}
}
