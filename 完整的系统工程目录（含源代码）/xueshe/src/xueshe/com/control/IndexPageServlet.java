package xueshe.com.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xueshe.com.dao.ClubDao;
import xueshe.com.model.Club;


@WebServlet("/IndexPageServlet")
public class IndexPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		ClubDao clubdao=new ClubDao();
		try {
			ArrayList<Club> clubList=clubdao.findClubsByCLname("");
			request.setAttribute("clubList", clubList);
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
