package dao;

import java.util.List;

import pojo.ShopCar;

public interface ShopCarDao {
	//��Ҳ�ѯ���ﳵ
	public List<ShopCar> findShopCarByUserId(int id);
	//����
	public int updateShopCar(ShopCar shopcar);
	//�����Ʒ
	public void add(ShopCar shopcar) ;
	//���Ҹ��û��Ƿ����и���Ʒ
	public ShopCar findShopCarByAUId(ShopCar shopcar);
	//ɾ��
	public void deleteByAUId(int articleId,int userId);
}
