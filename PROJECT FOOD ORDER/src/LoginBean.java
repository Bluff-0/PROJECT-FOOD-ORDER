import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginBean {
	String email,pass;
	boolean b=false;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean valid() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		PreparedStatement ps=cn.prepareStatement("select * from account where email=(?) and pass=(?)");
		ps.setString(1, email);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			b=true;
		}else {
			b=false;
		}
		ps.close();
		cn.close();
		return b;
	}
}
