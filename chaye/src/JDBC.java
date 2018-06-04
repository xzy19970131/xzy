
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class JDBC {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection  c=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chaye","root","root");  
		Statement  s=(Statement)c.createStatement();
			ResultSet  rs=((java.sql.Statement) s).executeQuery("select * from chaye where chayeid=2");
			while(rs.next()) {
				System.out.println(rs.getInt("chayeid")
						+"\t"+rs.getString("mingzi")
						+"\t"+rs.getInt("shoutu")
						+"\t"+rs.getInt("pinglunshu")
						+"\t"+rs.getInt("yuanjia")
						+"\t"+rs.getInt("xianjia"));
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}	

	}

}
