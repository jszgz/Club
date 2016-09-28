package xueshe.com.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xueshe.com.dao.ClubDao;
import xueshe.com.dao.CourseDao;
import xueshe.com.dao.StudentCourseDao;
import xueshe.com.dao.StudentDao;
import xueshe.com.model.Club;
import xueshe.com.model.Course;
import xueshe.com.model.Student;
import xueshe.com.model.StudentCourse;


@WebServlet(name="BackendStudentCourseServlet",urlPatterns={"/BackendStudentCourse.do","/BackendStudentCourseServlet"})
public class BackendStudentCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BackendStudentCourseServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String option=request.getParameter("option");
		String cno=request.getParameter("cno");
		String sno=request.getParameter("sno");
		StudentCourseDao scd=new StudentCourseDao();
		if(option.equals("delete"))
		{
			scd.deleteStudentCourse(sno, cno);
			response.sendRedirect("backend/studentcourselist.jsp");
		}else if(option.equals("edit"))
		{
			StudentCourse sc=new StudentCourse();
			sc=scd.getStudentCourseBySnoCno(sno, cno);
			request.setAttribute("studentcourse", sc);
			RequestDispatcher rd = request.getRequestDispatcher("backend/editstudentcourse.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		if(request.getParameter("option")!=null)
		{
			if(request.getParameter("option").equals("save"))
			{
				StudentCourseDao scd=new StudentCourseDao();
				StudentCourse sc=new StudentCourse();
				sc.setCno(request.getParameter("cno"));
				sc.setSno(request.getParameter("sno"));
				sc.setSCgrade(Double.parseDouble(request.getParameter("SCgrade")));
				scd.updataStudentCourse(sc);
				response.sendRedirect("backend/studentcourselist.jsp");
				return;
			}
		}
		
		
		
		String sno = request.getParameter("sno");
		String cno = request.getParameter("cno");

		StudentCourseDao scd=new StudentCourseDao();
		if(scd.insertStudentCourse(sno, cno))
		{
			request.setAttribute("message", "添加选课成功");
		}
		else
		{
			request.setAttribute("message", "失败，可能是该学生已经选择该课程");
		}
		RequestDispatcher rd = request.getRequestDispatcher("backend/newstudentcourse.jsp");
		rd.forward(request, response);
		
	}

}
