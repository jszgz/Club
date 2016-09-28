package xueshe.com.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xueshe.com.dao.CourseDao;
import xueshe.com.dao.StudentCourseDao;
import xueshe.com.model.Course;
import xueshe.com.model.Student;

@WebServlet("/CourseInfoServlet")
public class CourseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CourseInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String cno=request.getParameter("cno");
		CourseDao cd=new CourseDao();
		Course course=cd.getCourseByCno(cno);
		request.setAttribute("course", course);
		Student student=(Student) request.getSession().getAttribute("student");
		String sno=student.getSno();
		StudentCourseDao scd=new StudentCourseDao();
		if(scd.ifSelectedCourses(sno, cno))
		{
			String href;
			String option;
			if(request.getParameter("option")!=null)//只可能是原来选课后先要删除，故不需要判断option是否是delete
			{
				scd.deleteStudentCourse(sno, cno);
				href="CourseInfoServlet?option=select&cno="+cno;
				option="选择";
			}
			else
			{
				href="CourseInfoServlet?option=delete&cno="+cno;
				option="删除";
			}
			request.setAttribute("href", href);
			request.setAttribute("option", option);
			RequestDispatcher rd = request.getRequestDispatcher("/courseInfo.jsp?cno="+cno);
			rd.forward(request, response);
		}
		else
		{
			String href;
			String option;
			if(request.getParameter("option")!=null)//只可能是原来原来未选课要选课，故不需要判断option是否是select
			{
				scd.insertStudentCourse(sno, cno);
				href="CourseInfoServlet?option=delete&cno="+cno;
				option="删除";
				
			}
			else
			{
				href="CourseInfoServlet?option=select&cno="+cno;
				option="选择";
			}
			request.setAttribute("href", href);
			request.setAttribute("option", option);
			RequestDispatcher rd = request.getRequestDispatcher("/courseInfo.jsp?cno="+cno);
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
