package service;

import java.util.List;

import pojo.ArticleType;

public interface ArticleTypeService {
	//获取所有的一级物品类型
	public List<ArticleType> findAllFirstArticleType();
	//获取请求的一级物品类型，
	public ArticleType findFirstArticleTypeByCode(String firstArticleTypeCode);
	//获取请求的一级物品下的二级
	public List<ArticleType> findAllSecondArticleType(String firstArticleTypeCode);
}
