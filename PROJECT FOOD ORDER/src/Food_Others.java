

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Food_Others")
public class Food_Others extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Food_Others() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int count=0;
		Connection cn=DBManager.getConnection();
		PreparedStatement ps=null,ps1=null;
		try {
			ps=cn.prepareStatement("select * from FOODADD where TYPE=(?)");
			ps.setString(1, "Others");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				count++;
			}
			rs.close();
			ps.close();
			ps=cn.prepareStatement("select * from FOODADD where TYPE=(?)");
			ps.setString(1, "Others");
			rs=ps.executeQuery();
			ps1=cn.prepareStatement("select * from FOODADD where TYPE=(?)");
			ps1.setString(1, "Others");
			ResultSet rs2=ps1.executeQuery();
			
			if(rs.next())
			{
			out.println( 
					"<div class=\"banner\" id=\"shop\">\r\n" + 
					"<img src=\"images/Logo.jpg\" height=\"200\" style='margin-left:370px'>\r\n" + 
					"<div class=\"\" align=\"left\">\r\n" + 
					"         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n" +  
					"        <a href=\"Home\"><button type=\"button\" value=\"Home\" class=\"menub\">Home</button></a>\r\n" + 
					"        <a href=\"Food_Others\"><button type=\"button\" value=\"Home\" class=\"menub\">Shop</button></a>\r\n" + 
					"        <a href=\"Login.jsp\"><button type=\"button\" value=\"Home\" class=\"menub\">Log-in</button></a>\r\n" + 
					"        <a href=\"contact.html\"><button type=\"button\" value=\"Contact Us\" class=\"menub\">Contact Us</button></a>\r\n" + 
					"       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
					"        <span class=\"right\"><a href=\"ShoppingCart\" target=\"_top\" class=\"menub\">\r\n" + 
					"          <span class=\"glyphicon glyphicon-shopping-cart\"></span> Shopping Cart\r\n" + 
					"        </a></span>\r\n" + 
					"    </div>\r\n" + 
					"</div>"); 
			out.println("<div id=\"full\">\r\n" + 
					"    <span id=\"optn\" onclick=\"open1()\">&nbsp;&#10095;&nbsp;</span>\r\n" + 
					"    <center><h1 style=\"color: black; text-shadow: 2px 2px rgba(0,0,0,0.5); font-family: elephant;\"><span style=\"background-color: cornsilk; opacity: 0.9; border-radius: 10%\">&#9679; OTHERS &#9679;</span></h1></center>");
			
			for(int i=0;i<count;i++)
			{
				if(rs2.next())
				{
					out.println("<div class=\"col-sm-4\">\r\n" + 
							"			<div style=\"background-color: cornsilk; width: 350px; border-radius: 10%; opacity: 0.9;\">\r\n" +
							"			<form method=\"post\" action=\"FoodToCart\" class='FoodToCart'>\r\n" + 
							"			<input type=\"hidden\" name=\"foodType\" value=\"Others\" class=\"foodType\"/>\r\n" + 
							"    		<br/><center><img src=\"RetrivedFood/"+rs2.getString("FILENAME")+"\" height=\"300px\" width=\"300px\"/></center><input type=\"hidden\" name=\"fileName\" value="+rs2.getString("FILENAME")+" class=\"fileName\"/>\r\n" + 
							"    		<center><h3 style=\"color: darkred;\"><b>&#8226;"+rs2.getString("NAME")+"&#8226;</b></h3></center><input type=\"hidden\" name=\"foodName\" value="+rs2.getString("NAME")+" class=\"foodName\"/><h3 style=\"color: darkred;display:inline;margin-left:45px;\">&#8377;"+rs2.getFloat("PAY")+"</h3><input type=\"hidden\" name=\"price\" value="+rs2.getFloat("PAY")+" class=\"price\"/>"
									+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
							"				<button type=\"submit\" class=\"submit\" style=\"border-radius: 10%; width: 120px;\"><span class=\"glyphicon glyphicon-shopping-cart\"></span>Add to Cart</button>\r\n" + 
							"    </center><br/><br/>\r\n" + 
							"</form></div></div>");
				}
			}
			out.println("</div>");
			RequestDispatcher rd=request.getRequestDispatcher("/Foodpage.jsp");
			rd.include(request, response);
			
			}else {
				out.println("<h1>Sorry Please ask Admin to add Food of the specific food Categories</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("/Foodpage.jsp");
				rd.include(request, response);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		


	
	}

}
