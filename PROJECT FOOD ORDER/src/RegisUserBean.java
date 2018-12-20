import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisUserBean {
	String name,mob,email,pass;
	boolean b=false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

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
		Connection cn=DBManager.getConnection();
		PreparedStatement ps=cn.prepareStatement("insert into account values (?,?,?,?)");
		ps.setString(3, name);
		ps.setString(1, email);
		ps.setString(4, mob);
		ps.setString(2, pass);
		int i=ps.executeUpdate();
		if(i!=0)
		{
			b= true;
		}else {
			b= false;
		}
		ps.close();
		cn.close();
		return b;
	}
	
}

