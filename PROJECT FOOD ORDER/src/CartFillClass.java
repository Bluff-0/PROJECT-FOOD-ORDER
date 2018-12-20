import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

public class CartFillClass {
	static long orderNo;
	public void fillCart(HttpSession session)
	{
		String email=(String) session.getAttribute("Email");
		if(email!=null)
		{
		//Generating Order Number
		double r=Math.random();
		int part=(int)(r*10000);
		orderNo=12100000L+part;
		
		try {
		Connection cn=DBManager.getConnection();
		PreparedStatement ps1=cn.prepareStatement("insert into FOODINFO values (?,?,?,?)");
		ps1.setString(1, email);
		ps1.setLong(2, orderNo);
		ps1.setFloat(3, TakePrice.price);
		ps1.setString(4, "PLACED");
		
		//To check if the table is inseted or not..
		int res=ps1.executeUpdate();
		if(res!=0)
		{
			System.out.println("INserted In TAble");
		}else {
			System.out.println("Not iNserted");
		}
		
		PreparedStatement pstemp=cn.prepareStatement("select * from TEMPCART");
		ResultSet rs=pstemp.executeQuery();
		while(rs.next())
		{
		PreparedStatement ps=cn.prepareStatement("insert into USERCART values (?,?,?,?,?,?)");
		ps.setString(1, email);
		ps.setLong(2, orderNo);
		ps.setString(3, rs.getString("NAME"));
		ps.setString(4, rs.getString("TYPE"));
		ps.setString(5, rs.getString("FILENAME"));
		ps.setFloat(6, rs.getFloat("PRICE"));
		ps.executeUpdate();
		ps.close();
		}
		pstemp.close();
		pstemp=cn.prepareStatement("delete from TEMPCART");
		cn.commit();
		
		pstemp.close();
		cn.close();
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
		}
	}
}
