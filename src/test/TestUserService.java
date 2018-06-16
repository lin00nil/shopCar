package test;

import java.util.List;

import service.UserService;
import serviceImpl.UserServiceImpl;

public class TestUserService {
	public static void main(String[] args) {
		UserService service=new UserServiceImpl();
//		List<User> list=service.getAllUser();
//		for(User user:list){
//			System.err.println(user);
//		}
		
//		String name="xiaojia";
//		String pwd="1234";
//		User user=service.login(name, pwd);
//		System.out.println(user);
		
//		System.out.println("----模糊查询——---");
//		List<User> list=service.getByLike("jia");
//		for(int i=0;i<list.size();i++){
//			User user=list.get(i);
//			System.out.println(user);
//		}
		
//		User user=new User();
//		user.setName("wang");
//		user.setPwd("2342");
//		user.setAddress("不知道");
//		user.setPhone(12343);
//		service.addUser(user);
//		删除
//		service.deleteUserById(4);
//		更新
//		User user=new User();
//		user.setId(2);
//		user.setName("xiaojia2");
//		user.setPwd("2342");
//		user.setAddress("不知道");
//		user.setPhone(12343);
//		service.updateUser(user);
//		获取全部（连接表、
		/*List<User> list=service.getAll();
		for(User user:list){
			System.out.println(user);
		}*/
	}
}
