package dao;

import java.util.List;

import pojo.ArticleType;

public interface ArticleTypeDao {
	//��ȡ���е�һ����Ʒ����
	public List<ArticleType> findAllFirstArticleType();
	//��ȡ�����һ����Ʒ����
	public ArticleType findFirstArticleTypeByCode(String firstArticleTypeCode);
	//��ȡ�����һ����Ʒ�����µĶ�����Ʒ
	public List<ArticleType> findAllSecondArticleType(String firstArticleTypeCode);
}
