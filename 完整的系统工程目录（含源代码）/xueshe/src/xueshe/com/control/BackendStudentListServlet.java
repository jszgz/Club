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

@WebServlet("/BackendStudentListServlet")
public class BackendStudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BackendStudentListServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		StudentDao sd=new StudentDao();
		ArrayList<Student> studentList=new ArrayList<Student>();
		
		
		int page=1;
		
		if(request.getParameter("page")!=null)
			page=Integer.parseInt(request.getParameter("page"));
		
		int totalrecord=sd.getAllStudentsRecord();
		
		int perpage=8;
		
		int pagenumber=totalrecord/perpage;
		if((totalrecord%perpage)!=0)
			pagenumber++;
		
		studentList=sd.getAllStudentsWithPage(perpage, page);
		
		request.setAttribute("page", page);
		request.setAttribute("perpage", perpage);
		
		String pageactive="<ul>";
		for(int i=1;i<=pagenumber;++i)
		{
			pageactive+="<li";
			if(i==page)
				pageactive+=" class=\"active\"";
			pageactive+="><a href=\"../BackendStudentListServlet?page="+i+"\">"+i+"</a></li>";
		}
		pageactive+="</ul>";
		
		request.setAttribute("li", pageactive);
		
		
		
		
		request.setAttribute("studentList", studentList);
		RequestDispatcher rd = request.getRequestDispatcher("backend/studentlist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
