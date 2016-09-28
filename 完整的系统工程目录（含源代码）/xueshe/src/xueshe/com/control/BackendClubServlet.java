package xueshe.com.control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import xueshe.com.dao.ClubDao;
import xueshe.com.model.Club;

@WebServlet(name="BackendClubServlet",urlPatterns={"/BackendClub.do","/BackendClubServlet"})
@MultipartConfig(location="D:\\")
public class BackendClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BackendClubServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String option=request.getParameter("option");
		String clno=request.getParameter("clno");
		ClubDao cld=new ClubDao();
		if(option.equals("delete"))
		{
			cld.deleteClub(clno);
			
			
			String path=this.getServletContext().getRealPath("/");
			String dir=path+"images\\clubs\\"+clno;
			File delfolder=new File(dir); 
			  File oldFile[] = delfolder.listFiles();
			  try 
			  { 
			     for (int i = 0; i < oldFile.length; i++)
			     {
			        oldFile[i].delete();
			     }
			  } 
			  catch (Exception e) 
			  { 
			    System.out.println("清空文件夹操作出错!"); 
			    e.printStackTrace(); 
			  }
			  delfolder.delete();

			
			
			response.sendRedirect("backend/clublist.jsp");
		}else if(option.equals("edit"))
		{
			Club club=new Club();
			club=cld.getClubByCLno(clno);
			request.setAttribute("club", club);
			RequestDispatcher rd = request.getRequestDispatcher("backend/editclub.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("option")!=null)
		{
			if(request.getParameter("option").equals("save"))
			{
				ClubDao cld=new ClubDao();
				Club club=new Club();
				club.setCLno(request.getParameter("clno"));
				club.setCLname(request.getParameter("clname"));
				club.setCLabout(request.getParameter("clabout"));
				cld.updateClub(club);
				
				
				
				String clno=request.getParameter("clno");
				Part p=request.getPart("clubimage");
				String path=this.getServletContext().getRealPath("/");
				String filepath=path+"images\\clubs\\"+clno;
				File f=new File(filepath);
				if(!f.exists())
				{
					f.mkdirs();
				}
				p.write(filepath+"\\thumbnail.jpg");
				System.out.println(path);
				System.out.println(filepath);
				
				
				
				
				response.sendRedirect("BackendClubListServlet");
				return;
			}
		}
		
		
		String clname=request.getParameter("clname");
		String clabout=request.getParameter("clabout");
		String temp="CL";
		int i=1;
		ClubDao cd=new ClubDao();
		ArrayList<String> clnoList=cd.getAllCLno();
		while(clnoList.contains(temp+i))
		{
			i++;
		}
		String clno=temp+i;
		
		
		Part p=request.getPart("clubimage");
		String path=this.getServletContext().getRealPath("/");
		String filepath=path+"images\\clubs\\"+clno;
		File f=new File(filepath);
		if(!f.exists())
		{
			f.mkdirs();
		}
		p.write(filepath+"\\thumbnail.jpg");
		System.out.println(path);
		System.out.println(filepath);
		
		
		
		
		
		
		
		
		Club club=new Club();
		club.setCLno(clno);
		club.setCLname(clname);
		club.setCLabout(clabout);
		cd.insertClub(club);
		request.setAttribute("message", "添加社团成功");
		RequestDispatcher rd = request.getRequestDispatcher("backend/newclub.jsp");
		rd.forward(request, response);
	}

}
