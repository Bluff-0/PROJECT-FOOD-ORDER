

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterUser() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String mob=request.getParameter("con");
		String email=request.getParameter("email");
		String pass=request.getParameter("password1");
		RegisUserBean rb=new RegisUserBean();
		rb.setEmail(email);
		rb.setMob(mob);
		rb.setName(name);
		rb.setPass(pass);
		boolean b=false;
		try {
			b=rb.valid();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(b)
		{
			RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);
		}else {
			out.println("<h1>Something happened from our side!!<h1>");
			RequestDispatcher rd=request.getRequestDispatcher("/RegisterUser.jsp");
			rd.include(request, response);
		}
	}

}
