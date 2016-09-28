package xueshe.com.control;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(name="BackendImageUploadServlet",urlPatterns={"/BackendImageUploadServlet","/BackendImageUpload.do"})
@MultipartConfig(location="D:\\")
public class BackendImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BackendImageUploadServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String index=request.getParameter("index");
		Part p=request.getPart("image");
		String path=this.getServletContext().getRealPath("/");
		String filepath=path+"images\\excellent_course\\"+index+".jpg";

		p.write(filepath);
		request.setAttribute("message", "更换成功");
		RequestDispatcher rd = request.getRequestDispatcher("backend/uploadimage.jsp");
		rd.forward(request, response);
		
	}

}
