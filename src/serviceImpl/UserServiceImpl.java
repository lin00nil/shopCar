package serviceImpl;

import java.util.List;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import pojo.User;
import service.UserService;

//接口实现类
public class UserServiceImpl implements UserService{
	//创建多态操作数据库,接口（左边）=UserDaoImpl实现类（右边）
	UserDao userDao=new UserDaoImpl();
//	public List<User> getAllUser(){
//		return userDao.getAllUser();
//	}
	@Override
	public User login(String name, String pwd) {
		// TODO Auto-generated method stub
		User user=userDao.login(name, pwd);
		if(user!=null){
			System.out.println("用户存在");
		}else{
			System.out.println("用户不存在");
		}
		return user;
	}
//	@Override
//	public List<User> getByLike(String name) {
//		// TODO Auto-generated method stub
//		return userDao.getByLike(name);
//	}
	//添加一条记录
	public void addUser(User user){
		userDao.addUser(user);
	}
//	@Override
//	public void deleteUserById(int id) {
//		// TODO Auto-generated method stub
//		userDao.deleteUserById(id);
//	}
//	@Override
//	public void updateUser(User user) {
//		// TODO Auto-generated method stub
//		userDao.updateUser(user);
//	}
//	@Override
//	public List<User> getAll() {
//		// TODO Auto-generated method stub
//		return userDao.getAll();
//	}
	
}
