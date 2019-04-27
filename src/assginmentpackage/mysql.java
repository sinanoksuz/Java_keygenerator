package assginmentpackage;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
public class mysql {
	java.sql.Statement stmt;
	public void sqlconnec(String Macadress,String serial) throws Exception { 	
				try {
					
				String url = "jdbc:sqlite:test.db" ;
				 Class.forName("org.sqlite.JDBC");
				Connection conn=DriverManager.getConnection(url);
				
				 String sql = "CREATE TABLE IF NOT EXISTS key_generate (\n"
			                + "	Mac_adress TEXT NOT NULL UNIQUE,\n"
			                + "	Serial TEXT NOT NULL"
			                + ");";

				 stmt=    conn.createStatement();
				 stmt.execute(sql);
				 stmt.close();
				 conn.close();
				String query="INSERT INTO key_generate(Mac_adress,Serial) "+
				 	  "VALUES('"
				 		+Macadress+"','"+serial+"');";
				  conn = null;
					conn=DriverManager.getConnection(url);
				 java.sql.PreparedStatement stmtt= conn.prepareStatement(query);
				stmtt.executeUpdate();
			stmtt.close();	
			conn.close();
			
		}
		catch (Exception e) {
			throw e;
					}
		
		
	}

	private void prepareStatement(String query) {
		// TODO Auto-generated method stub
		
	}
}
