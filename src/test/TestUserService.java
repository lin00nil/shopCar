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
		
//		System.out.println("----ģ����ѯ����---");
//		List<User> list=service.getByLike("jia");
//		for(int i=0;i<list.size();i++){
//			User user=list.get(i);
//			System.out.println(user);
//		}
		
//		User user=new User();
//		user.setName("wang");
//		user.setPwd("2342");
//		user.setAddress("��֪��");
//		user.setPhone(12343);
//		service.addUser(user);
//		ɾ��
//		service.deleteUserById(4);
//		����
//		User user=new User();
//		user.setId(2);
//		user.setName("xiaojia2");
//		user.setPwd("2342");
//		user.setAddress("��֪��");
//		user.setPhone(12343);
//		service.updateUser(user);
//		��ȡȫ�������ӱ�
		/*List<User> list=service.getAll();
		for(User user:list){
			System.out.println(user);
		}*/
	}
}
