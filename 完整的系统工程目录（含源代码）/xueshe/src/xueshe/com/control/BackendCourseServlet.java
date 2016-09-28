package xueshe.com.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xueshe.com.dao.ClubCourseDao;
import xueshe.com.dao.ClubDao;
import xueshe.com.dao.CourseDao;
import xueshe.com.model.Club;
import xueshe.com.model.Course;


@WebServlet(name="BackendCourseServlet",urlPatterns={"/BackendCourse.do","/BackendCourseServlet"})
public class BackendCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BackendCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String option=request.getParameter("option");
		String cno=request.getParameter("cno");
		CourseDao cd=new CourseDao();
		if(option.equals("delete"))
		{
			cd.deleteCourse(cno);
			response.sendRedirect("backend/courselist.jsp");
		}else if(option.equals("edit"))
		{
			Course course=new Course();
			course=cd.getCourseByCno(cno);
			request.setAttribute("course", course);
			RequestDispatcher rd = request.getRequestDispatcher("backend/editcourse.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("option")!=null)
		{
			if(request.getParameter("option").equals("save"))
			{
				CourseDao cd=new CourseDao();
				Course course=new Course();
				course.setCno(request.getParameter("cno"));
				course.setCname(request.getParameter("cname"));
				course.setCyear(request.getParameter("cyear"));
				course.setCteacher(request.getParameter("cteacher"));
				cd.updateCourse(course);
				response.sendRedirect("backend/courselist.jsp");
				return;
			}
			
		}
		
		
		String clname=request.getParameter("clname");
		String cname=request.getParameter("cname");
		String cyear=request.getParameter("cyear");
		String cteacher=request.getParameter("cteacher");
		String temp="C";
		int i=1;
		CourseDao cd=new CourseDao();
		ArrayList<String> cnoList=cd.getAllCno();
		while(cnoList.contains(temp+i))
		{
			i++;
		}
		String cno=temp+i;
		ClubDao cld=new ClubDao();
		Club club=cld.getClubByCLname(clname);
		if(club!=null)
		{
			String clno=club.getCLno();
			Course course=new Course();
			course.setCno(cno);
			course.setCname(cname);
			course.setCteacher(cteacher);
			course.setCyear(cyear);
			cd.insertCourse(course);
			ClubCourseDao ccd=new ClubCourseDao();
			ccd.insertClubCourse(clno, cno);
			request.setAttribute("message", "添加课程成功");
			
		}else
		{
			request.setAttribute("message", "不存在该社团");
		}
		RequestDispatcher rd = request.getRequestDispatcher("backend/newcourse.jsp");
		rd.forward(request, response);
	}

}
