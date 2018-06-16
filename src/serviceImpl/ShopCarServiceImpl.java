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
	public int updateShopCar(int userId, int articleId, int buyNum) {
		// TODO Auto-generated method stub
		return shopCarDao.updateShopCar(userId, articleId, buyNum);
	}

}
