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
import xueshe.com.dao.CourseDao;
import xueshe.com.model.Club;
import xueshe.com.model.Course;
import xueshe.com.model.CourseCount;


@WebServlet(name="BackendStatisticServlet",urlPatterns={"/BackendStatisticServlet","/BackendStatistic.do"})
public class BackendStatisticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BackendStatisticServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		ClubDao clb=new ClubDao();
		CourseDao cd=new CourseDao();
		ArrayList<Club> clubList=clb.getAllClub();
		ArrayList<String> cyearList=cd.getAllCyear();
		request.getSession().setAttribute("clubList", clubList);
		request.getSession().setAttribute("cyearList", cyearList);
		response.sendRedirect("backend/chartclubcourse.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String clno=request.getParameter("clno");
		String cyear=request.getParameter("cyear");
		System.out.println(clno);
		System.out.println(cyear);
		ArrayList<CourseCount> coursecountList=new ArrayList<CourseCount>();
		if(cyear.equals("所有年份"))
			cyear="";
		if(clno.equals("所有社团"))
		{
			CourseDao cd=new CourseDao();
			coursecountList=cd.getCoursesYearStatistic(cyear);
			ArrayList<Course> clist=new ArrayList<Course>();
			ArrayList<String> scourselist=new ArrayList<String>();
			clist=cd.getAllCourseS();
			for(int i=0;i<coursecountList.size();++i)
			{
				scourselist.add(coursecountList.get(i).getCname());
			}
			for(int i=0;i<clist.size();++i)
			{
				if(!scourselist.contains(clist.get(i).getCname()))
				{
					CourseCount cc=new CourseCount();
					cc.setCname(clist.get(i).getCname());
					cc.setStatistic(0);
					coursecountList.add(cc);
				}
			}
			
		}else
		{
			ClubDao cld=new ClubDao();
			coursecountList=cld.getClubCoursesYearStatistic(clno, cyear);
			ArrayList<Course> clist=new ArrayList<Course>();
			ArrayList<String> scourselist=new ArrayList<String>();
			clist=cld.getClubCourses(clno, cyear);
			for(int i=0;i<coursecountList.size();++i)
			{
				scourselist.add(coursecountList.get(i).getCname());
			}
			for(int i=0;i<clist.size();++i)
			{
				if(!scourselist.contains(clist.get(i).getCname()))
				{
					CourseCount cc=new CourseCount();
					cc.setCname(clist.get(i).getCname());
					cc.setStatistic(0);
					coursecountList.add(cc);
				}
			}
		}
		int max=0;
		for(int i=0;i<coursecountList.size();++i)
		{
			if(coursecountList.get(i).getStatistic()>max)
			{
				max=coursecountList.get(i).getStatistic();
			}
		}
		for(int i=0;i<coursecountList.size();++i)
		{
			int statistic=coursecountList.get(i).getStatistic();
			int width=1+(int)((double)statistic/(double)max*700);
			String style="width: "+width+"px; height: 30px; background: #666; float: left;";
			coursecountList.get(i).setStyle(style);
		}
		request.setAttribute("coursecountList", coursecountList);
		RequestDispatcher rd = request.getRequestDispatcher("backend/chartclubcourse.jsp");
		rd.forward(request, response);
	}

}
