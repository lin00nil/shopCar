package serviceImpl;

import java.util.List;

import dao.ShopCarDao;
import daoImpl.ShopCarDaoImpl;
import pojo.ShopCar;
import service.ShopCarService;

public class ShopCarServiceImpl implements ShopCarService{
	ShopCarDao shopCarDao=new ShopCarDaoImpl();
	@Override
	public List<ShopCar> findShopCarByUserId(int id) {
		// TODO Auto-generated method stub
		return shopCarDao.findShopCarByUserId(id);
	}
	@Override
	public int updateShopCar(ShopCar shopcar) {
		// TODO Auto-generated method stub
		return shopCarDao.updateShopCar(shopcar);
	}
	@Override
	public void add(ShopCar shopcar) {
		// TODO Auto-generated method stub
		shopCarDao.add(shopcar);
	}
	@Override
	public ShopCar findShopCarByAUId(ShopCar shopcar) {
		// TODO Auto-generated method stub
		return shopCarDao.findShopCarByAUId(shopcar);
	}
	@Override
	public void deleteByAUId(int articleId, int userId) {
		// TODO Auto-generated method stub
		shopCarDao.deleteByAUId(articleId,userId);
	}


}
