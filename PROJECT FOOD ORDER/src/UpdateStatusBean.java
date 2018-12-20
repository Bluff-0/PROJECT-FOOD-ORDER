import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateStatusBean {
	String status;
	long orderNo;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}
	public void valid() throws Exception
	{
		Connection cn=DBManager.getConnection();
		PreparedStatement ps=cn.prepareStatement("update FOODINFO set STATUS=(?) where ORDERNO=(?)");
		ps.setString(1, status);
		ps.setLong(2, orderNo);
		int i=ps.executeUpdate();
		if(i!=0)
		{
			System.out.println("Status Updated");
			
		}else {
			System.out.println("Ststus Update Not Possible Some Bugs Found!!!!");
		}
		ps.close();
		cn.close();
	}
}
