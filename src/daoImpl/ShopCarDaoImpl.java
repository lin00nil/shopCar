package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dao.ShopCarDao;
import pojo.Article;
import pojo.OrderItem;
import pojo.ShopCar;
import pojo.User;

public class ShopCarDaoImpl extends DAO implements ShopCarDao{

	@Override
	public List<ShopCar> findShopCarByUserId(int id) {
		// TODO Auto-generated method stub
		String sql="select s.*,a.* from shopcar s,article a where s.articleId=a.id and userId=?";
		Object params[]={id};
		ResultSet rs=query(sql,params);
		List<ShopCar> list=new ArrayList();
		try {
			while(rs.next()){
				//取出记录并封装到对象中
				Article article=new Article();
				article.setId(rs.getInt("articleId"));
				article.setTitle(rs.getString("title"));
				article.setSupplier(rs.getString("supplier"));
				article.setPrice(rs.getDouble("price"));
				article.setDiscount(rs.getDouble("discount"));
				article.setLocality(rs.getString("locality"));
				article.setPutawayDate(rs.getDate("putaway_Date"));
				article.setStorage(rs.getInt("storage"));
				article.setImage(rs.getString("image"));
				article.setDescription(rs.getString("description"));
				article.setTypeCode(rs.getString("type_code"));
				article.setCreateDate(rs.getDate("create_Date"));
				article.setDisabled(rs.getString("disabled"));
				ShopCar shopCar=new ShopCar();
				shopCar.setId(rs.getInt("id"));
				shopCar.setArticleId(rs.getInt("articleId"));
				shopCar.setBuyNum(rs.getInt("buyNum"));
				shopCar.setUserId(rs.getInt("userId"));
				shopCar.setArticle(article);
				list.add(shopCar);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭资源
		close();
		return list;
	}

	@Override
	public int updateShopCar(ShopCar shopcar) {
		// TODO Auto-generated method stub
		String sql="update shopcar set buyNum=? where userId=? and articleId=?";
		Object params[]={shopcar.getBuyNum(),shopcar.getUserId(),shopcar.getArticleId()};
		int total=updata(sql,params);
		close();
		return total;
	}
	public void add(ShopCar shopcar) {
		// TODO Auto-generated method stub
		String sql="insert into shopcar(articleId,buyNum,userId)"+
				" values(?,?,?)";
		Object params[]={shopcar.getArticleId(),shopcar.getBuyNum(),shopcar.getUserId()};
		updata(sql,params);
		close();
	}

	@Override
	public ShopCar findShopCarByAUId(ShopCar shopcar) {
		// TODO Auto-generated method stub
		String sql="select * from shopcar where userId=? and articleId=?";
		Object params[]={shopcar.getUserId(),shopcar.getArticleId()};
		ShopCar sc=null;
		//执行查询操作
		ResultSet rs=query(sql,params);
		try {
			while(rs.next()){
				sc=new ShopCar();
				sc.setId(rs.getInt("id"));
				sc.setArticleId(rs.getInt("articleId"));
				sc.setBuyNum(rs.getInt("buyNum"));
				sc.setUserId(rs.getInt("userId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return sc;
	}

	@Override
	public void deleteByAUId(int articleId, int userId) {
		// TODO Auto-generated method stub
		String sql="delete from ShopCar where userId=? and articleId=?";
		Object params[]={userId,articleId};
		updata(sql,params);
		close();
	}
}
