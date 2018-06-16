package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ArticleTypeDao;
import dao.DAO;
import pojo.ArticleType;

public class ArticleTypeDaoImpl extends DAO implements ArticleTypeDao{
	//��ȡ���е�һ����Ʒ����
		public List<ArticleType> findAllFirstArticleType(){
			String sql="select * from article_type where length(trim(code))=4";
			Object params[]={};
			List<ArticleType> list=new ArrayList<ArticleType>();
			//ִ��
			ResultSet rs=query(sql,params);
			try {
				while(rs.next()){
					//ȡ����¼����װ��������
					ArticleType articleType=new ArticleType();
					articleType.setCode(rs.getString("code"));
					articleType.setName(rs.getString("name"));
					articleType.setRemark(rs.getString("remark"));
					//���������list��
					list.add(articleType);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//�ر���Դ
			close();
			return list;		
		}
		//��ȡ�����һ����Ʒ����
		@Override
		public ArticleType findFirstArticleTypeByCode(String firstArticleTypeCode) {
			// TODO Auto-generated method stub
			String sql="select * from article_type where code=?";
			Object params[]={firstArticleTypeCode};
			//ִ��
			ResultSet rs=query(sql,params);
			ArticleType articleType=null;
			try {
				while(rs.next()){
					//ȡ����¼����װ��������
					articleType=new ArticleType();
					articleType.setCode(rs.getString("code"));
					articleType.setName(rs.getString("name"));
					articleType.setRemark(rs.getString("remark"));				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close();		
			return articleType;
		}
		@Override
		public List<ArticleType> findAllSecondArticleType(String firstArticleTypeCode) {
			// TODO Auto-generated method stub
			String sql="select * from article_type where code like ?";
			Object params[]={firstArticleTypeCode+'%'};
			List<ArticleType> list=new ArrayList<ArticleType>();
			//ִ��
			ResultSet rs=query(sql,params);
			try {
				while(rs.next()){
					ArticleType articleType=new ArticleType();
					articleType.setCode(rs.getString("code"));
					articleType.setName(rs.getString("name"));
					articleType.setRemark(rs.getString("remark"));
					//���������list��
					list.add(articleType);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//�ر���Դ
			close();
			return list;
		}
}
