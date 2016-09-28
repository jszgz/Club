package xueshe.com.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xueshe.com.dao.StudentCourseDao;
import xueshe.com.model.StudentCourse;

@WebServlet("/BackendStudentCourseListServlet")
public class BackendStudentCourseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BackendStudentCourseListServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		StudentCourseDao scd=new StudentCourseDao();
		ArrayList<StudentCourse> studentcourseList=new ArrayList<StudentCourse>();
		studentcourseList=scd.getAllStudentCourses();
	
		request.setAttribute("studentcourseList", studentcourseList);
		RequestDispatcher rd = request.getRequestDispatcher("backend/studentcourselist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
