package serviceImpl;

import java.util.List;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import pojo.User;
import service.UserService;

//�ӿ�ʵ����
public class UserServiceImpl implements UserService{
	//������̬�������ݿ�,�ӿڣ���ߣ�=UserDaoImplʵ���ࣨ�ұߣ�
	UserDao userDao=new UserDaoImpl();
//	public List<User> getAllUser(){
//		return userDao.getAllUser();
//	}
	@Override
	public User login(String name, String pwd) {
		// TODO Auto-generated method stub
		User user=userDao.login(name, pwd);
		if(user!=null){
			System.out.println("�û�����");
		}else{
			System.out.println("�û�������");
		}
		return user;
	}
//	@Override
//	public List<User> getByLike(String name) {
//		// TODO Auto-generated method stub
//		return userDao.getByLike(name);
//	}
	//���һ����¼
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
