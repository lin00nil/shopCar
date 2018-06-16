package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dao.UserDao;
import pojo.User;

public class UserDaoImpl extends DAO implements UserDao{
	//查询所有记录
//	public List<User> getAllUser(){
//		String sql="select * from user";
//		Object params[]={};
//		List<User> list=new ArrayList<User>();
//		//执行
//		ResultSet rs=query(sql,params);
//		try {
//			while(rs.next()){
//				//取出记录并封装到对象中
//				User user=new User();
//				user.setId(rs.getInt("id"));
//				user.setPwd(rs.getString("pwd"));
//				user.setAddress(rs.getString("address"));
//				//将对象放入list中
//				list.add(user);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//关闭资源
//		close();
//		return list;
//	}

	@Override
	public User login(String loginName, String pwd) {
		// TODO Auto-generated method stub
		String sql="select * from user"+
				" where login_name=? and password=?";
		Object params[]={loginName,pwd};
		//声明一个User对象
		User user=null;
		//执行查询操作
		ResultSet rs=query(sql,params);
		try {
			while(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setLoginName(rs.getString("login_name"));
				user.setpassword(rs.getString("password"));
				user.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return user;
	}

//	@Override
//	public List<User> getByLike(String loginName) {
//		// TODO Auto-generated method stub
//		String sql="select * from user where login_name like ?";
//		Object params[]={'%'+loginName+'%'};
//		List<User> list=new ArrayList<User>();
//		//执行
//		ResultSet rs=query(sql,params);
//		try {
//			while(rs.next()){
//				User user=new User();
//				//取出记录并封装到对象中
//				user.setId(rs.getInt("id"));
//				user.setPwd(rs.getString("pwd"));
//				user.setAddress(rs.getString("address"));
//				user.setPhone(rs.getInt("phone"));	
//				//将对象放入list中
//				list.add(user);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//关闭资源
//		close();
//		return list;
//	}
	//添加
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		String sql="insert into user(login_name,password,address,phone)"+
				" values(?,?,?,?)";
		Object params[]={user.getLoginName(),user.getpassword(),user.getAddress(),user.getPhone()};
		updata(sql,params);
		close();
	}
	//删除
//	@Override
//	public void deleteUserById(int id) {
//		// TODO Auto-generated method stub
//		String sql="delete from user where id=?";
//		Object params[]={id};
//		updata(sql,params);
//		close();
//	}
	//修改
//	@Override
//	public void updateUser(User user) {
//		// TODO Auto-generated method stub
//		String sql="update user set login_name=?,pwd=?,address=?,phone=? where id=?";
//		Object params[]={user.getloginName(),user.getPwd(),user.getAddress(),user.getPhone(),user.getId()};
//		updata(sql,params);
//		close();
//	}

//	@Override
//	public List<User> getAll() {
//		// TODO Auto-generated method stub
//		String sql="select u.*,g.*"+
//				" from user u,goods g"+
//				" where u.gid=g.id";
//		Object params[]={};
//		List<User> list=new ArrayList<User>();
//		ResultSet rs=query(sql,params);
//		try {
//			while(rs.next()){
//				//取出记录并封装到对象中
//				User user=new User();
//				user.setId(rs.getInt("id"));
//				user.setPwd(rs.getString("pwd"));
//				user.setAddress(rs.getString("address"));
//				user.setPhone(rs.getInt("phone"));	
//				//商品信息
//				Goods good=new Goods();
//				good.setGid(rs.getInt("id"));
//				good.setGloginName(rs.getString("gloginName"));
//				good.setGprice(rs.getInt("gprice"));
//				//将对象放入list中
//				user.setGoods(good);
//				list.add(user);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		close();
//		return list;
//	}
}
