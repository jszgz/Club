package xueshe.com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BackendLogin.do")
public class BackendLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BackendLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("admin")&&password.equals("admin"))
		{
			request.getSession().setAttribute("login", "true");
			response.sendRedirect("backend/welcome.jsp");
		}
		else
		{
			request.getSession().setAttribute("message", "密码错误");
			response.sendRedirect("backend/login.jsp");
		}
	}

}
