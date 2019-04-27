package generatorlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.PreparedStatement;

public class mysql {
	public static String error;
	JTable table;
	ResultSet rs;
	String [][] strrr;
	String []strr;
	int a;
	public mysql(JTable table) {
		this.table=table;
	}
	public void sqlupdate(String Macadress,String serial) throws Exception { 	
		try {	
			String url = "jdbc:sqlite:test.db" ;
			Class.forName("org.sqlite.JDBC");
			
			String str=" UPDATE key_generate SET Serial='"+serial+
			 	  "' WHERE Mac_adress='"+Macadress+"'";
				Connection conn=DriverManager.getConnection(url);
				Statement stmt=conn.createStatement();
				stmt.executeUpdate(str);
					
				}
		catch (Exception e) {
					throw e;
				}
		Filltable();
	}
	public void Filltable() throws Exception {
		int a=0;
		try {
			String url = "jdbc:sqlite:test.db" ;
			Class.forName("org.sqlite.JDBC");
			String sql = "CREATE TABLE IF NOT EXISTS key_generate (\n"
		                + "	Mac_adress TEXT NOT NULL UNIQUE,\n"
		                + "	Serial TEXT NOT NULL"
		                + ");";
			Connection conn=DriverManager.getConnection(url);
			Statement stmt= conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			String stra="SELECT * FROM key_generate";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(stra);
			String s=rs.getMetaData().getColumnName(1);
		    String ss=rs.getMetaData().getColumnName(2);
		    ArrayList<String> arraymac=new ArrayList<>();
		    ArrayList<String> arrayser=new ArrayList<>();
		    while (rs.next()) {
				
				 arraymac.add(rs.getString("Mac_adress"));
				 arrayser.add(rs.getString("Serial"));
				  a++;
			}
		    strrr=new String [arraymac.size()+1][2];
		    strrr[0][0]=s;
			strrr[0][1]=ss;
		    for (int i = 1; i <= arraymac.size(); i++) {
				strrr[i][0]=arraymac.get(i-1);
				strrr[i][1]=arrayser.get(i-1);
			}
		   strr=new String[2];
		   strr[0]=s;
		   strr[1]=ss;
		   MyModel tablemodel=new MyModel(strrr, strr);
		   table.setModel(tablemodel);
		   rs.close();
		   stmt.close();
		   conn.close();
				
			  
		}
		catch (Exception e) {
		   e.printStackTrace();
				}
	}
	public void delet(String Mac_adress) throws Exception {
		
		try {
		   String url = "jdbc:sqlite:test.db" ;
		   Class.forName("org.sqlite.JDBC");
		   String str="DELETE FROM key_generate WHERE Mac_adress='"+Mac_adress+"'";
		   Connection conn=DriverManager.getConnection(url);
		   Statement stmt=conn.createStatement();
		   stmt.executeUpdate(str);
		   stmt.close();
		   conn.close();
			
		}
		catch (Exception e) {
		   throw e;
		}
		Filltable();
	}
	
	}

