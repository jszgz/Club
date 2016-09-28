package xueshe.com.control;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/loginFilter")
public class loginFilter implements Filter {

	public loginFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse) response;
		if (httprequest.getSession().getAttribute("student") == null) {
			httpresponse.sendRedirect("login.jsp");
		}
		else if(request.getParameter("clno")==null)
		{
			httpresponse.sendRedirect("index.jsp");
		}
		else{
			RequestDispatcher rd=httprequest.getRequestDispatcher("ClubServlet");
			rd.forward(httprequest, httpresponse);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
