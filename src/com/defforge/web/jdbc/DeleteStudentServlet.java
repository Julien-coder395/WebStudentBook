package com.defforge.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDbUtil studentDbUtil;
    
    @Resource(name="jdbc/studentdb")
    private DataSource dataSource;
    
    int id;
       
    @Override
    public void init() throws ServletException {
    	super.init();
    	studentDbUtil = new StudentDbUtil(dataSource);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		id = Integer.parseInt(request.getParameter("studentId"));
		studentDbUtil.deleteStudent(id);
		response.sendRedirect("StudentControllerServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
