package xueshe.com.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xueshe.com.dao.StudentDao;
import xueshe.com.model.Student;

@WebServlet(name="LoginServlet",urlPatterns={"/login.do"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		StudentDao studentdao=new StudentDao();
		try {
			Student student=studentdao.getStudentBySno(username);
			if(student==null)
			{
				request.setAttribute("message", "不存在该学生");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}else if(!student.getSpassword().equals(password)){
				request.setAttribute("message", "学号或密码错误");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else{
				HttpSession session=request.getSession();
				session.setAttribute("student", student);
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
