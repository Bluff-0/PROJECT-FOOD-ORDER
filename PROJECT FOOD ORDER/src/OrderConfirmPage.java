

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/OrderConfirmPage")
public class OrderConfirmPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public OrderConfirmPage() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int count=0;
		
		//For Estimated Date
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
		LocalDateTime now = LocalDateTime.now();
	    LocalDateTime then = now.plusDays(1);
	    String date=String.format(then.format(format));
	    /////////////////////////////////////////
	    
		Connection cn=DBManager.getConnection();
		HttpSession session=request.getSession(false);
		String email=(String) session.getAttribute("Email");
		if(session!=null)
		{
		try {
			PreparedStatement ps=cn.prepareStatement("select * from FOODINFO where ORDERNO=(?)");
			ps.setLong(1, CartFillClass.orderNo);
			ResultSet rs=ps.executeQuery();
			
			PreparedStatement ps1=cn.prepareStatement("select * from ACCOUNT where EMAIL=(?)");
			ps1.setString(1, email);
			ResultSet rs1=ps1.executeQuery();
			
			PreparedStatement ps2=cn.prepareStatement("select * from FOODINFO where EMAIL=(?)");
			ps2.setString(1, email);
			ResultSet rs2=ps2.executeQuery();
			while(rs2.next())
			{
				count++;
			}
			rs2.close();
			ps2.close();
			
			ps2=cn.prepareStatement("select * from FOODINFO where EMAIL=(?)");
			ps2.setString(1, email);
			rs2=ps2.executeQuery();
			
		if(rs.next() && rs1.next() )
		{
		out.println("<div class=\"banner\" id=\"home\">\r\n" + 
				"<img src=\"images/Logo.jpg\" height=\"200\" style=\"margin-left: 500px;\">\r\n" + 
				"<div class=\"\" align=\"left\">\r\n" + 
				"         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
				"    \r\n" + 
				"        <a href='Home' style='text-decoration:none;'><button type=\"button\" value=\"Home\" class=\"menub\"\">Home</button></a>\r\n" + 
				"        <a href='Logout' style='text-decoration:none;'><button type=\"button\" value=\"Home\" class=\"menub\" onclick=\"goal();\">Log-Out</button></a>\r\n" + 
				"        <button type=\"button\" value=\"Contact Us\" class=\"menub\" onclick=\"window.location.href=('Home');\">Contact Us</button>\r\n" + 
				"</div>\r\n" + 
				"</div>");
		out.println("<br><br>");
		
		out.println("<div class=\"OrderDetails\" style=\"margin-left: 300px;margin-right: 300px;\">\r\n" + 
				"		<br>\r\n" + 
				"	<fieldset>\r\n" + 
				"	<table cols=\"2\" style=\"width: 100%;font-size: 20px;text-align: center\" >\r\n" + 
				"		<tr><td style=\"width: 50%;color: blueviolet;font-weight: bold\">ORDER NUMBER:</td><td style=\"width: 50%;color: green;font-weight: bold\">"+rs.getLong("ORDERNO")+"</td></tr>\r\n" + 
				"		<tr><th>&nbsp;</th><th>&nbsp;</th></tr>\r\n" + 
				"		<tr><td style=\"width: 50%;color: blueviolet;font-weight: bold\">PRICE:</td><td style=\"width: 50%;color: green;font-weight: bold\">&#8377;"+rs.getFloat("PRICE")+"</td></tr>\r\n" + 
				"		<tr><th>&nbsp;</th><th>&nbsp;</th></tr>\r\n" + 
				"		<tr><td style=\"width: 50%;color: blueviolet;font-weight: bold\">DELIVERY ON:</td><td style=\"width: 50%;color: green;font-weight: bold\">"+date+"</td></tr>\r\n" + 
				"		<tr><th>&nbsp;</th><th>&nbsp;</th></tr>\r\n" + 
				"		</table>\r\n" + 
				"		<label style=\"align: center;\">-----------------------------------------------------------------------------------------------------------------------------------------</label><br>\r\n" + 
				"		<label style=\"color: red\">*PLEASE NOTE DOWN THE ORDER NUMBER FOR FUTURE REFERENCE.</label><br>\r\n" + 
				"		<label style=\"color: red\">*ANY QUERY FEEL FREE TO CONTACT OUR HELPLINE</label>\r\n" + 
				"		</fieldset>\r\n" + 
				"	</div>");
		out.println("<br><br> ");
		out.println("<div><div class=\"mid\" style=\"float: left\"><br>\r\n" + 
				"    <fieldset>\r\n" + 
				"    <h2 style=\"color: black; background-color: skyblue; text-shadow: 2px 2px rgba(0,0,0,0.8); font-family: elephant; text-align: center;\">&#9679; USER DETAILS &#9679;</h2><br><br><br>\r\n" + 
				"    <table style=\"margin-left: 120px\">\r\n" + 
				"    <tr><th style=\"width: 50%; color: darkblue; font-size: 25px;\">NAME:</th><th style=\"width: auto; color: darkgreen; font-size: 20px;\">"+rs1.getString("NAME")+"</th></tr>\r\n" + 
				"    <tr><th style=\"width: 50%; color: darkblue; font-size: 25px;\">CONTACT NO:</th><th style=\"width: auto; color: darkgreen; font-size: 20px;\">"+rs1.getString("MOB")+"</th></tr>\r\n" + 
				"    <tr><th style=\"width: 50%; color: darkblue; font-size: 25px;\">EMAIL:</th><th style=\"width: auto; color: darkgreen; font-size: 20px;\">"+rs1.getString("EMAIL")+"</th></tr>\r\n" + 
				"    </table></fieldset>\r\n" + 
				"</div>");
		out.println("<div><div class=\"mid\" style=\"float: right;\"><br>\r\n" + 
				"    <fieldset>\r\n" + 
				"    <h2 style=\"color: black; background-color: skyblue; text-shadow: 2px 2px rgba(0,0,0,0.8); font-family: elephant; text-align: center;\">&#9679; USER ORDERS &#9679;</h2><br><br><br>\r\n" + 
				"    <table style=\"margin-left: 120px;\">\r\n" + 
				"    <tr><th class=\"od1\">Order-id</th><th class=\"od1\">Price</th><th class=\"od1\">Order Status</th></tr>");
		for(int i=0;i<count;i++)
		{
			if(rs2.next())
			{
			out.println("<tr><th class=\"od2\">"+rs2.getLong("ORDERNO")+"</th><th class=\"od2\">"+rs2.getFloat("PRICE")+"</th><th class=\"od2\">"+rs2.getString("STATUS")+"</th></tr>");
			}
			
		}
		out.println("</table></fieldset>\r\n" + 
				"</div></div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
		out.println("<div style=\"background-color: powderblue;\" align=\"left\"><h5><b>&copy;Project Food Service (ISO 9001). All rights reserved.</b></h5></div>");
		
		//Attaching to the Original Page...
		RequestDispatcher rd=request.getRequestDispatcher("/User.jsp");
		rd.include(request, response);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		}
}
	}



