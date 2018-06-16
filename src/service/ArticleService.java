package service;

import java.util.List;

import pojo.Article;

public interface ArticleService {
	//根据物品类型和关键字查询所有的商品
	public List<Article> findByCodeAndKeyWord(String keyword,String typecode);

	public Article findById(String id);

}
