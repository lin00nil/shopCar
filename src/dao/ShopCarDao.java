package dao;

import java.util.List;

import pojo.ShopCar;

public interface ShopCarDao {
	//买家查询购物车
	public List<ShopCar> findShopCarByUserId(int id);
	//更新
	public int updateShopCar(ShopCar shopcar);
	//添加商品
	public void add(ShopCar shopcar) ;
	//查找该用户是否已有该商品
	public ShopCar findShopCarByAUId(ShopCar shopcar);
	//删除
	public void deleteByAUId(int articleId,int userId);
}
