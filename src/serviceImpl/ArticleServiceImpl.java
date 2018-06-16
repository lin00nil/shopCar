package serviceImpl;

import java.util.List;

import dao.ArticleDao;
import daoImpl.ArticleDaoImpl;
import pojo.Article;
import service.ArticleService;

public class ArticleServiceImpl implements ArticleService{
	ArticleDao articleDao=new ArticleDaoImpl();
	//根据物品类型和关键字查询所有的商品
	public List<Article> findByCodeAndKeyWord(String keyword,String typecode){
		return articleDao.findByCodeAndKeyWord(keyword,typecode);
	}
	@Override
	public Article findById(String id) {
		// TODO Auto-generated method stub
		return articleDao.findById(id);
	}
}
