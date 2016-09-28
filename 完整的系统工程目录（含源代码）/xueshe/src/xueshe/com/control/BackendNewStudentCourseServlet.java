package xueshe.com.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xueshe.com.dao.ClubDao;
import xueshe.com.dao.CourseDao;
import xueshe.com.dao.StudentDao;
import xueshe.com.model.Club;
import xueshe.com.model.Course;
import xueshe.com.model.Student;

@WebServlet("/BackendNewStudentCourseServlet")
public class BackendNewStudentCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BackendNewStudentCourseServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		CourseDao cd=new CourseDao();
		ArrayList<Course> courseList=new ArrayList<Course>();
		courseList=cd.getAllCourseS();
		StudentDao sd=new StudentDao();
		ArrayList<Student> studentList=new ArrayList<Student>();
		studentList=sd.getAllStudents();
		request.setAttribute("courseList", courseList);
		request.setAttribute("studentList", studentList);
		RequestDispatcher rd = request.getRequestDispatcher("backend/newstudentcourse.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
