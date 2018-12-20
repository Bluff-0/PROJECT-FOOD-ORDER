import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
static Connection cn;
public static java.sql.Connection getConnection()
{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
		
	}catch(Exception ee)
	{
		ee.printStackTrace();
	}
	return cn;
	
}
}
