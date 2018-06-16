package service;

import java.util.List;

import pojo.ArticleType;

public interface ArticleTypeService {
	//��ȡ���е�һ����Ʒ����
	public List<ArticleType> findAllFirstArticleType();
	//��ȡ�����һ����Ʒ���ͣ�
	public ArticleType findFirstArticleTypeByCode(String firstArticleTypeCode);
	//��ȡ�����һ����Ʒ�µĶ���
	public List<ArticleType> findAllSecondArticleType(String firstArticleTypeCode);
}
