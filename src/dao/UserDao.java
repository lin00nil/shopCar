package dao;

import java.util.List;

import pojo.User;

public interface UserDao {
//	查询全部记录
//	public List<User> getAllUser();
	//登录:根据用户名和密码查询(两个占位符）
	public User login(String name,String pwd);
	//对用户名进行模糊查询
//	public List<User> getByLike(String name);
	//添加一条记录
	public void addUser(User user);
	//根据主键删除一条指定的记录
//	public void deleteUserById(int id);
	//更新
//	public void updateUser(User user);
	//查重
	public int getUser(String userName);
}
