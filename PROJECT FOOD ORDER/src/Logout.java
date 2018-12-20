

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Logout() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			session.invalidate();
			session=null;
			System.out.println(session+"this is the session");
			RequestDispatcher rd=request.getRequestDispatcher("/Home");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("/Home");
			rd.forward(request, response);
		}
	}

}
