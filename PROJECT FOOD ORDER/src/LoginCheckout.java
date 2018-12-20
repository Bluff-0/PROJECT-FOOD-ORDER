

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginCheckout")
public class LoginCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginCheckout() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		LoginBean li=new LoginBean();
		li.setEmail(email);
		li.setPass(pass);
		boolean b=false;
		try {
			b=li.valid();
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
		if(b)
		{
			//Setting up of Session for sending login credential for further uses....
			HttpSession session=request.getSession();
			session.setAttribute("Email", email);
			
			//Entering items to User's Carts
			CartFillClass cs=new CartFillClass();
			cs.fillCart(session);
			
			//forwarding to CheckOut Page...
			RequestDispatcher rs=request.getRequestDispatcher("CheckoutPage");
			rs.forward(request, response);
		}else {
			out.println("<h1  style='color:white'>INVALID USER NAME OR PASSWORD</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("/LoginCheckout.jsp");
			rd.include(request, response);
		}

	}

}
