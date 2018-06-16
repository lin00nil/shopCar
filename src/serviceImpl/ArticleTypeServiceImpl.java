package serviceImpl;

import java.util.List;

import dao.ArticleDao;
import dao.ArticleTypeDao;
import daoImpl.ArticleDaoImpl;
import daoImpl.ArticleTypeDaoImpl;
import pojo.ArticleType;
import service.ArticleTypeService;

public class ArticleTypeServiceImpl implements ArticleTypeService{
	ArticleTypeDao articleTypeDao=new ArticleTypeDaoImpl();
	//��ȡ���е�һ����Ʒ����
	public List<ArticleType> findAllFirstArticleType(){
		return articleTypeDao.findAllFirstArticleType();
	}
	//��ȡ�����һ����Ʒ����
	public ArticleType findFirstArticleTypeByCode(String firstArticleTypeCode){
		return articleTypeDao.findFirstArticleTypeByCode(firstArticleTypeCode);
	}
	
	public List<ArticleType> findAllSecondArticleType(String firstArticleTypeCode){
		return articleTypeDao.findAllSecondArticleType(firstArticleTypeCode);
	}
}
