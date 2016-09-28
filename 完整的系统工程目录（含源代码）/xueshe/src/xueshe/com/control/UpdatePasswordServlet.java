package xueshe.com.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xueshe.com.dao.StudentDao;
import xueshe.com.model.Student;


@WebServlet("/updatePassword.do")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePasswordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Student oldStudent=(Student) request.getSession().getAttribute("student");
		String oldpassword=request.getParameter("spassword_old");
		String newpassword=request.getParameter("spassword_vary");
		StudentDao sd=new StudentDao();
		
		if(!oldStudent.getSpassword().equals(oldpassword))
		{
			request.setAttribute("message", "旧密码错误");
			RequestDispatcher rd=request.getRequestDispatcher("StudentPassword.jsp");
			rd.forward(request, response);
		}
		else
		{
			Student newstu=new Student();
			newstu.setSno(oldStudent.getSno());
			newstu.setSname(oldStudent.getSname());
			newstu.setSsex(oldStudent.getSsex());
			newstu.setSpassword(newpassword);
			sd.updateStudent(newstu);
			request.getSession().setAttribute("student", newstu);
			request.setAttribute("message", "修改成功,请牢记新密码");
			RequestDispatcher rd=request.getRequestDispatcher("StudentPassword.jsp");
			rd.forward(request, response);
		}
	}

}
