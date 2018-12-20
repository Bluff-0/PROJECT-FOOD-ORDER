

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/TakePrice")
public class TakePrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TakePrice() {
        super();
       
    }
    static float price;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		price=Float.parseFloat(request.getParameter("priceTotal"));
		
		//Checking if User Previously Loggedin or Not..
		HttpSession session=request.getSession(false);
		if(session==null)      //It suggests you are not logged in....as no sessions are found....in server...:-)
		{
			RequestDispatcher rs=request.getRequestDispatcher("/LoginCheckout.jsp");
			rs.forward(request, response);
		}else {
			CartFillClass cs=new CartFillClass();
			cs.fillCart(session);
			
			//forwarding to CheckOut Page...
			RequestDispatcher rs=request.getRequestDispatcher("CheckoutPage");
			rs.forward(request, response);
		}
	}

}
