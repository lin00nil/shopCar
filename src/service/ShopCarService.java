package service;

import java.util.List;

import pojo.ShopCar;

public interface ShopCarService {
	public List<ShopCar> findShopCarByUserId(int id);
	//����
	public int updateShopCar(ShopCar shopcar);
	//���
	public void add(ShopCar shopcar) ;
	//���Ҹ��û��Ƿ����и���Ʒ
	public ShopCar findShopCarByAUId(ShopCar shopcar) ;
}
