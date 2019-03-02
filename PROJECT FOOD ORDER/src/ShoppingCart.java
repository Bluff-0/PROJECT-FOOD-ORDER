

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
import javax.servlet.http.HttpSession;


@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShoppingCart() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int count=0;
		float sum=(float) 0.0;
		Connection cn=DBManager.getConnection();
		PreparedStatement ps=null,pst=null;
		
		
		
		
		try {
			ps=cn.prepareStatement("select * from TEMPCART");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				count++;
			}
			rs.close();
			ps.close();
			
			ps=cn.prepareStatement("select * from TEMPCART");
			rs=ps.executeQuery();
			pst=cn.prepareStatement("select * from TEMPCART");
			ResultSet rs1=pst.executeQuery();
			if(rs.next())
			{
				out.println("<div class=\"container\">\r\n" + 
						"	<table id=\"cart\" class=\"table table-hover table-condensed\" cols=\"4\">\r\n" + 
						"    				\r\n" + 
						"						<tr style=\"background-color: greenyellow\">\r\n" + 
						"							<th style=\"width:50%\" class=\"text-center\">Product</th>\r\n" + 
						"							<th style=\"width:10%\" class=\"text-center\">Price</th>\r\n" + 
						"							<th style=\"width:28%\" class=\"text-center\">Quantity</th>\r\n" + 
						"							<th style=\"width:18%\" class=\"text-center\">Sub Total</th>\r\n" + 
						"							<th style=\"width:10%\" class=\"text-center\">Remove</th>\r\n" + 
						"						</tr>\r\n" + 
						"					\r\n" + 
						"					<tbody>");
				for(int i=0;i<count;i++)
				{
					if(rs1.next()) {
					out.println("<tr class=\"p1\">\r\n" + 
							"							<th data-th=\"Product\">\r\n" + 
							"								<div class=\"row\">\r\n" + 
							"                                    <div class=\"col-sm-5\">\r\n" + 
							"										<h4 class=\"nomargin\"><img src=\"RetrivedFood/"+rs1.getString("FILENAME")+"\" width=\"80px\" height=\"80px\" style=\"border-radius: 20px\"></h4>\r\n" + 
							"									</div>\r\n" + 
							"									<div class=\"col-sm-7 text-center\">\r\n" + 
							"										<h4 class=\"nomargin\" style=\"font-family: Elephant;color:coral\">"+rs1.getString("NAME")+"</h4><br/>\r\n" + 
							"										<h6 class=\"nomargin\" style=\"font-family:Algerian;\">"+rs1.getString("TYPE")+"</h6>\r\n" + 
							"									</div>\r\n" + 
							"								</div>\r\n" + 
							"							</th>\r\n" + 
							"							<td data-th=\"Price\" class=\"text-center price\">"+rs1.getFloat("PRICE")+"</td>\r\n" + 
							"							<td data-th=\"Quantity\" class=\"text-center\">\r\n" + 
							"								<button type=\"button\" class=\"like text-center btn btn-warning btn-lg\" style=\"border-radius: 50%\"><strong style=\"font-family: Arial Rounded MT;font-size: 20px;\">-</strong></button>\r\n" + 
							"								<input type=\"number\" class=\"col-sm-4 figure\" value=\"1\" disabled style=\"height: 45px;background-color:lavender;border-radius: 8px;text-align: center;\">\r\n" + 
							"								<button type=\"button\" class=\"dislike text-center btn btn-warning btn-lg\" style=\"border-radius: 50%;width: inherit\"><strong style=\"font-family: Arial Rounded MT;font-size: 20px;\">+</strong></button>\r\n" + 
							"							</td>\r\n" + 
							"							<td data-th=\"Sub Total\" class=\"text-center subtotal\">"+rs1.getFloat("PRICE")+"</td>\r\n" + 
							"							<td class=\"actions text-center\" data-th=\"Remove\">\r\n" + 
							"							<form action=\"DelItemCart\" method=\"post\">\r\n" + 
							"							<input type=hidden class='foodName' value="+rs1.getString("NAME")+"><br/>\r\n" + 
							"				            <button class=\"clickid  btn btn-danger text-center\" value=\"click\" type=\"submit\"><i class=\"fa fa-trash-o\"></i></button>\r\n" + 
							"								</form>\r\n" + 
							"								</td>\r\n" + 
							"						</tr>");
					sum=sum+rs1.getFloat("PRICE");
					}
				}
				String Price=Float.toString(sum);
				out.println("</tbody>\r\n" + 
						"					<tfoot>\r\n" + 
						"						<tr>\r\n" + 
						"							<td><a href=\"Home\" class=\"btn btn-warning\"><i class=\"fa fa-angle-left\"></i> Continue Shopping</a></td>\r\n" + 
						"							<td colspan=\"2\" class=\"hidden-xs\"></td>\r\n" + 
						"							<td class=\"hidden-xs text-center totalpay\"><strong>"+sum+"</strong></td>\r\n" + 
						"							<td><form action='TakePrice' method='POST'><input type=hidden value="+Price+" class='priceTotal'>"+
						"<button type='submit' class=\"btn btn-success btn-block checkout\">Checkout <i class=\"fa fa-angle-right\"></i></button></form></td>\r\n" + 
						"						</tr>\r\n" + 
						"					</tfoot>\r\n" + 
						"				</table>\r\n" + 
						"</div> ");
				RequestDispatcher rd=request.getRequestDispatcher("/Cart.jsp");
				rd.include(request, response);
			}
			else {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}

	
	

