package shsm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ShsmManage {
   private static final String DRIVERNAME="com.mysql.jdbc.Driver";
   private static final String URL="jdbc:mysql://localhost:3306/store_management_system";
   private static final String USER="root";
   private static final String PASSWORD="root";
   private static ResultSet rst=null;
   private static Connection conn=null;
   private static PreparedStatement pst=null;
   
   public static Connection getconn(){
	   try {
		   Class.forName(DRIVERNAME);
		   conn=DriverManager.getConnection(URL,USER,PASSWORD);
	   } catch (ClassNotFoundException e) {
		// TODO: handle exception
		   e.printStackTrace();
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return conn;
   }
   public static ResultSet runSelect(String sql){
	   try {
		   conn=getconn();
		   pst=conn.prepareStatement(sql);
		   rst=pst.executeQuery();
	   } catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
	   }
	   return rst;
   }
   public static boolean runUpdate(String sql){
	   try {
		   conn=getconn();
		   pst=conn.prepareStatement(sql);
		   pst.executeUpdate();
		   return true;
	   } catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
		   return false;
	   }
	   
   }
}
