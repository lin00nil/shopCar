package service;


import java.util.List;

import pojo.User;


public interface UserService {
	//��ѯȫ����¼
//	public List<MyUser> getAllUser();
	//��¼:�����û����������ѯ(����ռλ����
	public User login(String name,String pwd);
	//���û�������ģ����ѯ
//	public List<MyUser> getByLike(String name);
	//���һ����¼
	public void addUser(User user);
	//��������ɾ��һ��ָ���ļ�¼
//	public void deleteUserById(int id);
	//����
//	public void updateUser(MyUser user);
	//��ѯ�û��Լ�����Ʒ
//	public List<MyUser> getAll();
	//����
		public int getUser(String userName);
}
