

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/additem")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
				maxFileSize=1024*1024*10,      // 10MB
				maxRequestSize=1024*1024*50)   // 50MB

public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset-UTF-8");
		
		PrintWriter out=response.getWriter();
		String name=request.getParameter("email");
		float price=Float.parseFloat(request.getParameter("price"));
		String description=request.getParameter("descrip");
		
		Part part=request.getPart("image");
		String filen=part.getSubmittedFileName();
		String name1=filen.substring(filen.lastIndexOf("\\")+1);
		String fileName=name1;
		String savepath="D:\\AdvJava\\PROJECT FOOD ORDER\\WebContent\\RetrivedFood"+File.separator+fileName;
		new File(savepath);
		part.write(savepath+File.separator);
		
		
		AddItemBean ab=new AddItemBean();
		ab.setDesc(description);
		ab.setName(name);
		ab.setPrice(price);
		ab.setSavepath(savepath);
		ab.setFilename(fileName);
		boolean b=false;
		try {
			b=ab.valid();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		if(b)
		{
			RequestDispatcher rd=request.getRequestDispatcher("/additem.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.print("<html><body><h1>NOT UPLOADED</h1></body></html>");
		}
		
	}
}

