package dao;

import java.util.List;

import pojo.ShopCar;

public interface ShopCarDao {
	//买家查询购物车
	public List<ShopCar> findShopCarByUserId(int id);
	//更新
	public int updateShopCar(int userId,int articleId,int buyNum);
}
