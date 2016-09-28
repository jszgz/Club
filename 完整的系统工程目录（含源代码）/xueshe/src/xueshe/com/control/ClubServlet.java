package xueshe.com.control;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Date;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xueshe.com.dao.ClubDao;
import xueshe.com.dao.CourseDao;
import xueshe.com.dao.StudentCourseDao;
import xueshe.com.model.Club;
import xueshe.com.model.Course;
import xueshe.com.model.Student;

@WebServlet("/ClubServlet")
public class ClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClubServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String clno=request.getParameter("clno");
		ClubDao clubdao=new ClubDao();
		try {
			Club club=clubdao.getClubByCLno(clno);
			Student student=(Student) request.getSession().getAttribute("student");
			StudentCourseDao studentcoursedao=new StudentCourseDao();
			Calendar a=Calendar.getInstance();
			String currentYear=""+a.get(Calendar.YEAR);
			ArrayList<Course> unselectedCourseList=studentcoursedao.getUnselectedCourses(student.getSno(), club.getCLno(),currentYear);
			ArrayList<Course> selectedCourseList=studentcoursedao.getSelectedCourses(student.getSno(), club.getCLno(),currentYear);
			request.setAttribute("club", club);
			request.setAttribute("unselectedCourseList", unselectedCourseList);
			request.setAttribute("selectedCourseList", selectedCourseList);
			RequestDispatcher rd=request.getRequestDispatcher("club.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
