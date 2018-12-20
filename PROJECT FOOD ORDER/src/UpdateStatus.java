

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateStatus() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderN=request.getParameter("orderNo");
		long orderNo=Long.parseLong(orderN);
		String status=request.getParameter("status");
		System.out.println(orderN);
		
		UpdateStatusBean ub=new UpdateStatusBean();
		ub.setOrderNo(orderNo);
		ub.setStatus(status);
		try {
			ub.valid();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
