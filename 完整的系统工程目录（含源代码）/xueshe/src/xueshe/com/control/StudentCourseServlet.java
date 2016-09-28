package xueshe.com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xueshe.com.dao.StudentCourseDao;
import xueshe.com.model.Student;


@WebServlet("/StudentCourseServlet")
public class StudentCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cno=request.getParameter("cno");
		Student student=(Student) request.getSession().getAttribute("student");
		String sno=student.getSno();
		StudentCourseDao scd=new StudentCourseDao();
		if(request.getParameter("option").equals("select"))
			scd.insertStudentCourse(sno, cno);
		else if(request.getParameter("option").equals("delete"))
			scd.deleteStudentCourse(sno, cno);
		String url="club.jsp?clno="+request.getParameter("clno");
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
