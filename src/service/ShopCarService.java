package service;

import java.util.List;

import pojo.ShopCar;

public interface ShopCarService {
	public List<ShopCar> findShopCarByUserId(int id);
	//更新
	public int updateShopCar(ShopCar shopcar);
	//添加
	public void add(ShopCar shopcar) ;
	//查找该用户是否已有该商品
	public ShopCar findShopCarByAUId(ShopCar shopcar) ;
}
