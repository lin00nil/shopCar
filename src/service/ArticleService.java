package service;

import java.util.List;

import pojo.Article;

public interface ArticleService {
	//������Ʒ���ͺ͹ؼ��ֲ�ѯ���е���Ʒ
	public List<Article> findByCodeAndKeyWord(String keyword,String typecode);

	public Article findById(String id);

}
