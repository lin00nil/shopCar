package dao;

import java.util.List;

import pojo.Article;
import pojo.ArticleType;

public interface ArticleDao {
	
	public List<Article> findByCodeAndKeyWord(String keyword, String typecode);
	//≤È’“…Ã∆∑
	public Article findById(String id);
	
}