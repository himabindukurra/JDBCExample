package com.bindu.jdbc;
import java.sql.*;

public class StudentDetails {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/student?";
		String uname = "root";
		String pswd = "root";
		String query = "select * from details";
		//String query1 = "insert into details (id, name) values ("null" ,"Anil Kumar")";
		String query1 = " insert into details (id, name)" + " values (?, ?)";
		//String query2 = " delete from details where id=6";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pswd);
		
		Statement stmt = con.createStatement();
		ResultSet rs= stmt.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		
		System.out.println("-------------------------------------");
		
		PreparedStatement preparedStmt;  
		
		/*
		PreparedStatement preparedStmt = con.prepareStatement(query1);
		preparedStmt.setInt (1,0);  
	    preparedStmt.setString (2, "Karthik");
	      
	    preparedStmt.execute();
		
	    rs= stmt.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		*/
		  String query2 = "delete from details where id = ?";
	      preparedStmt = con.prepareStatement(query2);
	      preparedStmt.setInt(1, 6);
	      
	      preparedStmt = con.prepareStatement(query2);
	      preparedStmt.setInt(1, 7);
	      
	      preparedStmt = con.prepareStatement(query2);
	      preparedStmt.setInt(1, 8);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
	    
	}

}
