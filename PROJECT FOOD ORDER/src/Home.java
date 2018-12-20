

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Home() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);//Checking the Login is Done Before or not
		if(session!=null)
		{
			String email=(String) session.getAttribute("Email");
			if(email==null) {
				session=null;
			}
		}
		
		Connection cn=DBManager.getConnection();
		if(session!=null)
		{	System.out.println("inside home");
			String email=(String) session.getAttribute("Email");
			System.out.println("Email is:"+email+" "+session);
			try {
				PreparedStatement ps=cn.prepareStatement("select * from ACCOUNT where EMAIL=(?)");
				ps.setString(1, email);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
				{
					out.println("<div class=\"banner\" id=\"home\">\r\n" + 
							"<img src=\"images/Logo.jpg\" height='200px;' style=\"margin-left: 370px;\">\r\n" + 
							"<div class=\"\" align=\"left\">\r\n" + 
							"         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
							"    \r\n" + 
							"        <a href=\"Home\"><button type=\"button\" value=\"Home\" class=\"menub\">Home</button></a>\r\n" + 
							"        <a href=\"#shop\"><button type=\"button\" value=\"Home\" class=\"menub\">Shop</button></a>\r\n" + 
							"        <a href=\"#contact\"><button type=\"button\" value=\"Contact Us\" class=\"menub\">Contact Us</button></a>\r\n" + 
							"<a href=\"Logout\" ><button type=\"button\" value=\"Home\" class=\"menub\" onclick=\"hola();\">Log-out/"+rs.getString("NAME")+"</button></a>"+ 
							"        \r\n" + 
							"        \r\n" + 
							"       \r\n" + 
							"        <span class=\"right\" style=\"float: right;margin-right: 30px; text-decoration: none\" ><a href=\"ShoppingCart\" target=\"_top\" class=\"menub\" style=\"text-decoration: none\">\r\n" + 
							"          <span class=\"glyphicon glyphicon-shopping-cart\" style=\"text-decoration:none\"></span> Shopping Cart\r\n" + 
							"        </a></span>\r\n" + 
							"    </div>\r\n" + 
							"</div>\r\n" + 
							"");
					RequestDispatcher rd=request.getRequestDispatcher("/Home.html");
					rd.include(request, response);
				}
				
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}else {
			out.println("<div class=\"banner\" id=\"home\">\r\n" + 
					"<img src=\"images/Logo.jpg\" height=\"200\" style=\"margin-left: 370px;\">\r\n" + 
					"<div class=\"\" align=\"left\">\r\n" + 
					"         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
					"    \r\n" + 
					"        <a href=\"Home\"><button type=\"button\" value=\"Home\" class=\"menub\">Home</button></a>\r\n" + 
					"        <a href=\"#shop\"><button type=\"button\" value=\"Home\" class=\"menub\">Shop</button></a>\r\n" + 
					"        <a href=\"#contact\"><button type=\"button\" value=\"Contact Us\" class=\"menub\">Contact Us</button></a>\r\n" + 
					"        <a href=\"#login\"><button type=\"button\" value=\"Home\" class=\"menub\">Log-in</button></a>\r\n" + 
					"        \r\n" + 
					"        \r\n" + 
					"       \r\n" + 
					
					"    </div>\r\n" + 
					"</div>\r\n" + 
					"");
			RequestDispatcher rd=request.getRequestDispatcher("/Home.html");
			rd.include(request, response);
		}
	}

}
