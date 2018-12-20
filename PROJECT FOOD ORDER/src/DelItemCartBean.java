import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DelItemCartBean {
	String foodName;
	
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public void valid() throws SQLException
	{
		Connection cn=DBManager.getConnection();
		PreparedStatement ps=cn.prepareStatement("delete from TEMPCART where NAME=(?)");
		ps.setString(1, foodName);
		int i=ps.executeUpdate();
		if(i!=0)
		{
			
		}
		cn.commit();
		ps.close();
		cn.close();
	}
	
}
