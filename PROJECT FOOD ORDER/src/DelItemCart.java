

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DelItemCart")
public class DelItemCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DelItemCart() {
        super();
       }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String foodName=request.getParameter("foodName");
		
		
		DelItemCartBean dd=new DelItemCartBean();
		dd.setFoodName(foodName);
		try {
			dd.valid();
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

}
