package dao;

import java.util.List;

import pojo.User;

public interface UserDao {
//	��ѯȫ����¼
//	public List<User> getAllUser();
	//��¼:�����û����������ѯ(����ռλ����
	public User login(String name,String pwd);
	//���û�������ģ����ѯ
//	public List<User> getByLike(String name);
	//���һ����¼
	public void addUser(User user);
	//��������ɾ��һ��ָ���ļ�¼
//	public void deleteUserById(int id);
	//����
//	public void updateUser(User user);
	//����
	public int getUser(String userName);
}
