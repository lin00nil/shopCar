package dao;

import java.util.List;

import pojo.ArticleType;

public interface ArticleTypeDao {
	//获取所有的一级物品类型
	public List<ArticleType> findAllFirstArticleType();
	//获取请求的一级物品类型
	public ArticleType findFirstArticleTypeByCode(String firstArticleTypeCode);
	//获取请求的一级物品类型下的二级物品
	public List<ArticleType> findAllSecondArticleType(String firstArticleTypeCode);
}
