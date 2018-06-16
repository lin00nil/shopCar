package dao;

import java.util.List;

import pojo.Article;
import pojo.ArticleType;

public interface ArticleDao {
	
	public List<Article> findByCodeAndKeyWord(String keyword, String typecode);
	//������Ʒ
	public Article findById(String id);
	
}