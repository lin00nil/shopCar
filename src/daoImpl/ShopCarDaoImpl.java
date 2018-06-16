package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dao.ShopCarDao;
import pojo.Article;
import pojo.ShopCar;

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
	public int updateShopCar(int userId, int articleId, int buyNum) {
		// TODO Auto-generated method stub
		String sql="update shopcar set buyNum=? where userId=? and articleId=?";
		Object params[]={buyNum,userId,articleId};
		int total=updata(sql,params);
		close();
		return total;
	}
	

}
