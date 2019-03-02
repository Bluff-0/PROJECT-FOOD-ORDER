

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckoutPage")
public class CheckoutPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckoutPage() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<div class=\"banner\" id=\"home\">\r\n" + 
				    "<img src=\"images/Logo.jpg\" height=\"200\" class=\"text-center\"></div><br><br><br>\r\n");
		out.println("<center><div class=\"a\" class=\"text-center\"><br>");
		out.println(" <form name=\"outform\" method=\"post\" action=\"OrderConfirmPage\">");
		out.println("<table style=\"border: 2px; border-color: darkblue;\" cellpadding=\"20px\">");
		out.println("<tr>\r\n" + 
				"            <th style=\"width: 50%; color: black; font-size: 25px; font-family: Courier;\">Amount:</th>\r\n" + 
				"            <th style=\"width: auto;\" colspan=\"2\"><input type=\"text\" name='price' placeholder="+TakePrice.price+" class=\"design\" disabled></th>\r\n" + 
				"            <th></th><th></th>\r\n" + 
				"        </tr>");
		out.println("</table><hr><br>");
		out.println("\r\n" + 
				"    <fieldset style=\"border-color: black; box-shadow: 2px 2px 2px 2px;\">\r\n" + 
				"    <table style=\"border: 2px; border-color: darkblue;\" cellpadding=\"10px\">\r\n");
		out.println("<tr>\r\n" +  
				"            <th style=\"width: 50%; color: black; font-size: 20px; font-family: Courier;\">Card Number:</th>\r\n" + 
				"            <th style=\"width: auto;\"><input type=\"text\" name=\"c1\" maxlength=\"4\" placeholder=\"XXXX\" class=\"design\" required></th>\r\n" + 
				"            <th style=\"width: auto;\"><input type=\"text\" name=\"c2\" placeholder=\"XXXX\" maxlength=\"4\" class=\"design\" required></th><th style=\"width: auto;\"><input type=\"text\" name=\"c3\" placeholder=\"XXXX\" maxlength=\"4\" class=\"design\" required></th><th style=\"width: auto;\"><input type=\"text\" name=\"c4\" placeholder=\"XXXX\" maxlength=\"4\" class=\"design\" required></th>\r\n" + 
				"        </tr><tr><th colspan=\"5\">&nbsp;</th></tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <th style=\"width: 50%; color: black; font-size: 20px; font-family: Courier;\";>Cardholder's Name: </th>\r\n" + 
				"            <th style=\"width: auto;\" colspan=\"4\"><input type=\"text\" name=\"c5\" placeholder=\"Enter Cardholder's Name\" class=\"design\" required>\r\n" + 
				"        </tr><tr><th colspan=\"5\">&nbsp;</th></tr>\r\n" + 
				"        <th style=\"width: 50%; color: black; font-size: 20px; font-family: Courier;\">Expiery Date:</th>\r\n" + 
				"        <th colspan=\"2\" style=\"width: auto;\"><select class=\"design\" name=\"c6\" required><option>Month</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>10</option><option>11</option><option>12</option></select></th>\r\n" + 
				"        <th colspan=\"2\" style=\"width: auto;\"><select class=\"design\" name=\"c7\"><option>Year</option><option>2018</option><option>2019</option><option>2020</option><option>2021</option></select></th><tr><th colspan=\"5\">&nbsp;</th></tr>\r\n" + 
				"        <tr>\r\n" + 
				"        <th style=\"width: 50%; color: black; font-size: 20px; font-family: Courier;\" colspan=\"2\">CVV:</th>\r\n" + 
				"        <th style=\"width: auto;\" colspan=\"2\"><input type=\"password\" name=\"c8\" placeholder=\"***\" maxlength=\"3\" class=\"design\" required>\r\n" + 
				"        </tr>\r\n" +
				"    </table><br><br>\r\n" + 
				"    </fieldset><br>\r\n" + 
				"    <button type=\"submit\" style=\"width: 150px; height: 45px; font-size: 18px; font-family: Comic Sans MS; border-radius: 7px; border-color: chocolate;\" onclick=\"return succc()\";>Proceed</button>\r\n" + 
				"</form>\r\n" + 
				"</div></center>");
		RequestDispatcher rs=request.getRequestDispatcher("/Checkout.jsp");
		rs.include(request, response);
					
	}

}
