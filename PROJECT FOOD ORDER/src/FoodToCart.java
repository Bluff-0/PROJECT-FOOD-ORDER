

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FoodToCart")
public class FoodToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FoodToCart() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("inside post");
		String name=request.getParameter("foodName");
		String type=request.getParameter("foodType");
		String filename=request.getParameter("fileName");
		float pay=Float.parseFloat(request.getParameter("price"));
		
		
		FoodToCartBean ff=new FoodToCartBean();
		ff.setFilename(filename);
		ff.setName(name);
		ff.setPay(pay);
		ff.setType(type);
		
		try {
			ff.valid();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
