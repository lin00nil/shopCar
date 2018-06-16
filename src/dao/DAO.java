package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO {
	private Connection con;
	private PreparedStatement statement;
	private ResultSet rs;
	public boolean getConnection(){
		boolean flag=false;
		try{
			//1.加载驱动
			String driver="com.mysql.jdbc.Driver";
			Class.forName(driver);
			//2.获取连接
			String url="jdbc:mysql://localhost:3306/shop";
			con=DriverManager.getConnection(url,"root","root");
			if(con!=null){
				flag=true;
				System.err.println("数据库连接成功");
			}else{
				System.err.println("数据库连接失败");
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	/*
	 * 查询(执行所有的查询)
	 */
	public ResultSet query (String sql,Object params[]){
		try{
			if(getConnection()){	//1.获取连接，2 利用返回结果
				//获取preparedStatement对象
				statement=con.prepareStatement(sql);
				//给占位符赋值,占位符从1开始，数组从0开始
				for(int i=0;i<params.length;i++){
					statement.setObject(i+1, params[i]);
				}
				//执行sql语句
				rs=statement.executeQuery();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	/*
	 * 查询(执行所有的查询)
	 */
	public int Query (String sql,Object...obj){
		int num=0;
		try{
			if(getConnection()){	//1.获取连接，2 利用返回结果
				//获取preparedStatement对象
				statement=con.prepareStatement(sql);
				//给占位符赋值,占位符从1开始，数组从0开始
				if(obj!=null){
					for(int i=0;i<obj.length;i++){
						statement.setObject(i+1, obj[i]);
					}
				}
				//执行sql语句
				rs=statement.executeQuery();
				//判断是否有下一个值
				if(rs.next()){
					num=rs.getInt(1);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return num;
	}
	/*
	 * 增删改
	 * users users
	 */
	public int updata(String sql,Object params[]){
		int total=0;//返回失败
		try{
			if(getConnection()){
				statement=con.prepareStatement(sql);
				for(int i=0;i<params.length;i++){
					statement.setObject(i+1,params[i]);
				}
				//执行并影响多少行
				total=statement.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return total;
	}
//	关闭数据库
	public void close(){
		try{
			if(rs!=null){
				rs.close();
			}
			if(statement!=null){
				statement.close();
			}
			if(con!=null){
				con.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
}
