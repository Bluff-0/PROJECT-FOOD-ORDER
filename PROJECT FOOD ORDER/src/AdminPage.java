

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


@WebServlet("/AdminPage")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminPage() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int count=0,c=0;
		float sum=(float) 0.0;
		
		
		Connection cn=DBManager.getConnection();
		try {
			PreparedStatement ps=cn.prepareStatement("select * from FOODINFO");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				count++;
			}
			rs.close();
			ps.close();
			
			ps=cn.prepareStatement("select * from FOODINFO");
			rs=ps.executeQuery();
			
			PreparedStatement ps1=cn.prepareStatement("select * from FOODINFO");
			ResultSet rs1=ps1.executeQuery();
			
			PreparedStatement ps2=cn.prepareStatement("select * from ACCOUNT");
			ResultSet rs2=ps2.executeQuery();
			while(rs2.next())
			{
				c++;
			}
			rs2.close();
			ps2.close();
			
			ps2=cn.prepareStatement("select * from ACCOUNT");
			rs2=ps2.executeQuery();
			
			
			
		out.println("<div class=\"banner\" id=\"home\">\r\n" + 
				"<center><img src=\"images/Logo.jpg\" height=\"200\"></center>\r\n" + 
				"<div class=\"\" align=\"left\">\r\n" + 
				"         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
				"    \r\n" + 
				"        <a href=\"#\"><button type=\"button\" value=\"Home\" class=\"menub\">Admin Home</button></a>\r\n" +
				"		 <a href=\"Home\"><button type=\"button\" value=\"Home\" class=\"menub\" >Log_Out</button></a>\r\n" +
				"        <a href=\"contact.html\"><button type=\"button\" value=\"Contact Us\" class=\"menub\" disabled>Contact Us</button></a>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n");
		out.println("<center><div>\r\n" + 
				"<h1 style=\"color: black; text-shadow: 2px 2px rgba(0,0,0,0.8); font-family: elephant; text-align: center;\">&#9679; ADMINISTRATOR &#9679;</h1>\r\n" + 
				"<div class=\"mid\" id=\"home\"><br><br>\r\n" + 
				"    <a href=\"additem.jsp\"><button type=\"button\" value=\"Home\" class=\"itemb\">Add New Food Items</button></a><br><br>\r\n" + 
				"</div></center><br><br>\r\n");
		out.println("<div class=\"mid\" style=\"float: left; height: auto;margin-left: 50px;\">\r\n" + 
				"    <fieldset>\r\n" + 
				"    <h2 style=\"color: black; background-color: skyblue; text-shadow: 2px 2px rgba(0,0,0,0.8); font-family: elephant; text-align: center; border-radius: 20%;\">&#9679; ALL ORDERS &#9679;</h2><br><br><br>\r\n" + 
				"    <table class=\"OrderManage\">\r\n" + 
				"    <tr><th class=\"od1\">Order-id</th><th class=\"od1\">Price</th><th class=\"od1\">Order Status</th><th class=\"od1\"></th></tr>\r\n");
			int i=0;
			do
			{
				if(rs1.next())
				{
					out.println("<tr><th class=\"od2\">"+rs1.getLong("ORDERNO")+"</th><th class=\"od2\">"+rs1.getFloat("PRICE")+"</th><th class=\"od2\"><select><option value=\"Placed\">Placed</option><option value=\"Shipped\">Shipped</option><option value=\"Arrived\">Arrived</option><option value=\"Delivered\">Delivered</option></select></th><th class=\"od2\"><form action=\"UpdateStatus\" method='POST'><br><input type='hidden' value="+rs1.getLong("ORDERNO")+"><input type='hidden' value='Placed'><input type=\"submit\" name=\"update\" value=\"UPDATE\" class=\"btn1\"></form></th></tr>");
					sum=sum+rs1.getFloat("PRICE");
				}else {
					out.println("<tr><th>NO USER DETAILS</th><th>TO</th><th>SHOW!!</th></tr>");
				}
				i++;
			}while(i<count);
			out.println(" </table>");
			out.println("<hr>\r\n" + 
					"    <span style=\"float: right;\">\r\n" + 
					"    <h3 style=\"color: darkblue; font-family: cursive;\"><b>$ Total Transaction $</b></h3>\r\n" + 
					"    <h4 style=\"color: darkgreen; font-family: cursive;\"><b>&#8377;"+sum+"</b></h4>\r\n" + 
					"    </span>\r\n" + 
					"    </fieldset>\r\n" + 
					"</div>"); 
			out.println("<div class=\"mid\" style=\"float: right; height: auto;margin-right: 50px\">\r\n" + 
					"    <fieldset>\r\n" + 
					"    <h2 style=\"color: black; background-color: skyblue; text-shadow: 2px 2px rgba(0,0,0,0.8); font-family: elephant; text-align: center; border-radius: 20%;\">&#9679; ALL USERS &#9679;</h2><br><br><br>\r\n" + 
					"    <table class='member'>\r\n" + 
					"    <tr><th class=\"od1\" style=\"width: 40%\">Name</th><th class=\"od1\" style=\"width: 33%\">Contact</th><th class=\"od1\" style=\"width: 33%\">E-mail</th></tr>\r\n");
			int j=0;
			do
			{
				if(rs2.next())
				{
				out.println("<tr><th class=\"od2\" style=\"width: 40%\">"+rs2.getString("NAME")+"</th><th class=\"od2\" style=\"width: 33%\">"+rs2.getString("MOB")+"</th><th class=\"od2\" style=\"width: 33%\">"+rs2.getString("EMAIL")+"</th></tr>\r\n");
				}else {
					System.out.println("INSIDE ELSE!!!");
					out.println("<tr><th>NO USER DETAILS</th><th>TO</th><th>SHOW!!</th></tr>");
				}
				j++;
			}while(j<c);
			out.println("</table></fieldset><br><br>\r\n" + 
					"</div>");
			out.println("</div>\r\n" + 
					"<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\r\n" + 
					"<div style=\"background-color: powderblue;\" align=\"left\"><h5><b>&copy;Project Food Service (ISO 9001). All rights reserved.</b></h5></div>\r\n" + 
					"</center>\r\n");
			RequestDispatcher rr=request.getRequestDispatcher("/Admin.jsp");
			rr.include(request, response);
		
			} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
		

}
