package service;

import java.util.List;

import pojo.ShopCar;

public interface ShopCarService {
	public List<ShopCar> findShopCarByUserId(int id);
	//¸üÐÂ
	public int updateShopCar(int userId,int articleId,int buyNum);
}
