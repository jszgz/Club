package xueshe.com.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xueshe.com.dao.StudentCourseDao;
import xueshe.com.model.Course;
import xueshe.com.model.Student;

@WebServlet("/StudentAllCourseServlet")
public class StudentAllCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentAllCourseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		if (request.getParameter("option") != null) {
			if (request.getParameter("option").equals("delete")) {
				String cno = request.getParameter("cno");
				Student student = (Student) request.getSession().getAttribute("student");
				String sno = student.getSno();
				StudentCourseDao scd = new StudentCourseDao();
				scd.deleteStudentCourse(sno, cno);
			}
		}

		
		StudentCourseDao scd = new StudentCourseDao();
		Student student = (Student) request.getSession().getAttribute("student");
		String sno = student.getSno();
		Calendar a = Calendar.getInstance();
		String currentYear = "" + a.get(Calendar.YEAR);
		ArrayList<Course> CourseList = scd.getAllSelectedCoursesIgnoreClub(sno, currentYear);
		request.setAttribute("CourseList", CourseList);
		RequestDispatcher rd = request.getRequestDispatcher("myCourse.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
