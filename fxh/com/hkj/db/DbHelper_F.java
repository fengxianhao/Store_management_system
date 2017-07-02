package fxh.com.hkj.db;

import java.sql.*;





public class DbHelper_F {
	//SQL数据库驱动类名
		private static final String DRIVER="com.mysql.jdbc.Driver";
		//SQL登录方式字符常量
		private static final String URL="jdbc:mysql://localhost:3306/store_management_system";
		private static final String USER="root";
		private static final String PSW="root";
		
		private static Connection conn=null;
		private static PreparedStatement pst=null;
		private static ResultSet res=null;
		
		//加载驱动
		static{
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//获取连接
		public static Connection getConnection(){
			Connection conn=null;
			try {
				return conn=DriverManager.getConnection(URL, USER, PSW);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		
		public static void main(String[] args) {
			Connection connection=DbHelper_F.getConnection();
			System.out.println(connection);
		}
		
		//关闭Connection
			public static void closeCon(Connection con){
				try
				{
					if(conn!=null)
						con.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			//关闭ResultSet
			public static void closeResultSet(ResultSet rs){
				try
				{
					if(rs!=null){
						rs.close();
						rs = null;
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			
			}
			
			//关闭Statement
			public static void closeStatement(Statement pst){
				try
				{
					if(pst!=null){
						pst.close();
						pst = null;
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			
			}
			
			
			
			
}
