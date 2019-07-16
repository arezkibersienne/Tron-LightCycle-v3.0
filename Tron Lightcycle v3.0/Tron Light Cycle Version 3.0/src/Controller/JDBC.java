package Controller;

import java.sql.*;

import com.mysql.jdbc.Statement;
public class JDBC {
	
	private String url;	//Url for the datebase
	private String user; //Database user 
	private String pwd; //Database password
	private String query; //Sql query
	Connection con = null; //Instance of Connection class
   public JDBC() {
      }
   public void testConnexion(String url , String user , String pwd) {
	   	 // String JdbcURL = "jdbc:mysql://localhost:3306/tron?useSSL=false";
	      //String Username = "root";
	      // String password = "130397nanaarezki";
	      
	      try {
	    	  //1. get connection to the database
	         con = DriverManager.getConnection(url, user, pwd);
	         System.out.println("Connected to MySQL database");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
   }
   
   public void sendQuery(String url , String user , String pwd ,String query) {
	   try {
	    	  //1. get connection to the database
	         con = DriverManager.getConnection(url, user, pwd);
	         System.out.println("Connected to MySQL database");
	         //2. create statement 
	         java.sql.Statement myStmt = con.createStatement();
	         //3. excute Sql query
	         ResultSet myRs = myStmt.executeQuery(query);
	         //4. process the result set
	         while(myRs.next()) {
	        	 System.out.println(myRs.getString("Player_name"));
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
   }
   
   public void addInDB(String player , Double time ,String url , String user , String pwd) {
	   try {
	    	  //1. get connection to the database
	         con = DriverManager.getConnection(url, user, pwd);
	         CallableStatement mySt = null;
	         System.out.println("Connected to MySQL database");
	         //2. create statement for procedure call
	         mySt = con.prepareCall("{call addPlayer(? , ?)}");
	         //3. set the parameters 
	         mySt.setString(1 , player);
	         mySt.setDouble(2, time);
	         //4. excute the procedure
	         mySt.execute();
	         System.out.println("Data added successfully to MySQL database");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
   }
}