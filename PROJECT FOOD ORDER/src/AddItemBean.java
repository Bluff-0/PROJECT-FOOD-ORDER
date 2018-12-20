import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddItemBean {
	
String name,desc,filename,savepath;
float price;
int is;
boolean b;

	public String getFilename() {
	return filename;
	}
	
	public void setFilename(String filename) {
	this.filename = filename;
	}
	
	public String getSavepath() {
	return savepath;
	}
	
	public void setSavepath(String savepath) {
	this.savepath = savepath;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean valid() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		PreparedStatement ps=cn.prepareStatement("insert into FOODADD values (?,?,?,?,?)");
		
		ps.setString(1, name);
		ps.setFloat(2,price);
		ps.setString(3, desc);
		ps.setString(4,filename);
		ps.setString(5, savepath);
		
		int i=ps.executeUpdate();
		if(i!=0)
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
