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

@WebFilter("/BackendLoginFilter")
public class BackendLoginFilter implements Filter {

    public BackendLoginFilter() {
        
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("dofilter");
		request.setCharacterEncoding("UTF-8");
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse) response;
		if(httprequest.getRequestURI().contains("backend/js")||httprequest.getRequestURI().contains("backend/css")||httprequest.getRequestURI().contains("backend/images")||httprequest.getRequestURI().contains("backend/fonts"))
		{
			System.out.println("dofilter111111111111111");
			chain.doFilter(request, response);
		}
		else
		{
		if(httprequest.getRequestURI().contains("login.jsp")){
			System.out.println("dofilter1");
			chain.doFilter(request, response);
		 }
		else if (httprequest.getSession().getAttribute("login") == null) {
			System.out.println("dofilter2");
			httpresponse.sendRedirect("login.jsp");
		} 
		else if(!((String)httprequest.getSession().getAttribute("login")).equals("true"))
		{
			System.out.println("dofilter3");
			httpresponse.sendRedirect("login.jsp");
		}
		else {
			System.out.println("dofilter4");
			chain.doFilter(request, response);
		}
		}
}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
