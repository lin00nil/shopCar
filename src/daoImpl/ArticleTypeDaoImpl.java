package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ArticleTypeDao;
import dao.DAO;
import pojo.ArticleType;

public class ArticleTypeDaoImpl extends DAO implements ArticleTypeDao{
	//获取所有的一级物品类型
		public List<ArticleType> findAllFirstArticleType(){
			String sql="select * from article_type where length(trim(code))=4";
			Object params[]={};
			List<ArticleType> list=new ArrayList<ArticleType>();
			//执行
			ResultSet rs=query(sql,params);
			try {
				while(rs.next()){
					//取出记录并封装到对象中
					ArticleType articleType=new ArticleType();
					articleType.setCode(rs.getString("code"));
					articleType.setName(rs.getString("name"));
					articleType.setRemark(rs.getString("remark"));
					//将对象放入list中
					list.add(articleType);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//关闭资源
			close();
			return list;		
		}
		//获取请求的一级物品类型
		@Override
		public ArticleType findFirstArticleTypeByCode(String firstArticleTypeCode) {
			// TODO Auto-generated method stub
			String sql="select * from article_type where code=?";
			Object params[]={firstArticleTypeCode};
			//执行
			ResultSet rs=query(sql,params);
			ArticleType articleType=null;
			try {
				while(rs.next()){
					//取出记录并封装到对象中
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
			//执行
			ResultSet rs=query(sql,params);
			try {
				while(rs.next()){
					ArticleType articleType=new ArticleType();
					articleType.setCode(rs.getString("code"));
					articleType.setName(rs.getString("name"));
					articleType.setRemark(rs.getString("remark"));
					//将对象放入list中
					list.add(articleType);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//关闭资源
			close();
			return list;
		}
}
