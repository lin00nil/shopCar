package dao;

import java.util.List;

import pojo.ShopCar;

public interface ShopCarDao {
	//��Ҳ�ѯ���ﳵ
	public List<ShopCar> findShopCarByUserId(int id);
	//����
	public int updateShopCar(int userId,int articleId,int buyNum);
}
