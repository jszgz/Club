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
import xueshe.com.dao.StudentDao;
import xueshe.com.model.Club;
import xueshe.com.model.Student;

@WebServlet(name = "BackendStudentServlet", urlPatterns = { "/BackendStudent.do", "/BackendStudentServlet" })
public class BackendStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BackendStudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String option=request.getParameter("option");
		String sno=request.getParameter("sno");
		StudentDao sd=new StudentDao();
		if(option.equals("delete"))
		{
			sd.deleteStudent(sno);
			response.sendRedirect("backend/studentlist.jsp");
		}else if(option.equals("edit"))
		{
			Student student=new Student();
			student=sd.getStudentBySno(sno);
			request.setAttribute("student", student);
			RequestDispatcher rd = request.getRequestDispatcher("backend/editstudent.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		if(request.getParameter("option")!=null)
		{
			if(request.getParameter("option").equals("save"))
			{
				StudentDao sd=new StudentDao();
				Student student=new Student();
				student.setSno(request.getParameter("sno"));
				student.setSname(request.getParameter("sname"));
				student.setSsex(request.getParameter("ssex"));
				student.setSpassword(request.getParameter("spassword"));
				sd.updateStudent(student);
				response.sendRedirect("backend/studentlist.jsp");
				return;
			}
		}

		
		String sname = request.getParameter("sname");
		String ssex = request.getParameter("ssex");
		String sno = request.getParameter("sno");
		String spassword = request.getParameter("spassword");

		StudentDao sd = new StudentDao();
		if (sd.getStudentBySno(sno) == null) {
			Student student = new Student();
			student.setSname(sname);
			student.setSno(sno);
			student.setSpassword(spassword);
			student.setSsex(ssex);
			sd.insertStudent(student);
			request.setAttribute("message", "添加学生成功");
		} else {
			request.setAttribute("message", "已经存在该学号，请前往修改");
		}
		RequestDispatcher rd = request.getRequestDispatcher("backend/newstudent.jsp");
		rd.forward(request, response);
	}

}
