package fxh.com.hkj.db;

import java.sql.*;





public class DbHelper_F {
	//SQL���ݿ���������
		private static final String DRIVER="com.mysql.jdbc.Driver";
		//SQL��¼��ʽ�ַ�����
		private static final String URL="jdbc:mysql://localhost:3306/store_management_system";
		private static final String USER="root";
		private static final String PSW="root";
		
		private static Connection conn=null;
		private static PreparedStatement pst=null;
		private static ResultSet res=null;
		
		//��������
		static{
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��ȡ����
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
		
		//�ر�Connection
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
			
			//�ر�ResultSet
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
			
			//�ر�Statement
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
