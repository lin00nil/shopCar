package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ArticleDao;
import dao.DAO;
import pojo.Article;
import pojo.ArticleType;

public class ArticleDaoImpl extends DAO implements ArticleDao{
	
	@Override
	public List<Article> findByCodeAndKeyWord(String keyword, String typecode) {
		
		String sql="select * from article  where TYPE_CODE like ? ";
		ResultSet rs=null;
		if(keyword !=null && !keyword.equals("")) {
			sql=sql+" and title like ?";
		}
		
		if(keyword !=null && !keyword.equals("")) {
			Object params[]={typecode+'%','%'+keyword+'%'};
			rs=query(sql,params);
		}else{
			Object params[]={typecode+'%'};
			rs=query(sql,params);
		}
		List<Article> list=new ArrayList<Article>();
		//ִ��
		try {
			while(rs.next()){
				Article article=new Article();
				//ȡ����¼����װ��������
				article.setId(rs.getInt("id"));
				article.setTitle(rs.getString("title"));
				article.setSupplier(rs.getString("supplier"));
				article.setPrice(rs.getDouble("price"));
				article.setDiscount(rs.getDouble("discount"));
				article.setLocality(rs.getString("locality"));
				article.setPutawayDate(rs.getDate("putaway_Date"));
				article.setStorage(rs.getInt("storage"));
				article.setImage(rs.getString("image"));
				article.setDescription(rs.getString("description"));
				article.setTypeCode(rs.getString("type_code"));
				article.setCreateDate(rs.getDate("create_Date"));
				article.setDisabled(rs.getString("disabled"));
				//���������list��
				list.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ر���Դ
		close();
		return list;
	}

	@Override
	public Article findById(String id) {
		// TODO Auto-generated method stub
		String sql="select * from article where id=?";
		Object params[]={id};
		ResultSet rs=query(sql,params);
		Article article=null;
		try {
			while(rs.next()){
				//ȡ����¼����װ��������
				article=new Article();
				article.setId(rs.getInt("id"));
				article.setTitle(rs.getString("title"));
				article.setSupplier(rs.getString("supplier"));
				article.setPrice(rs.getDouble("price"));
				article.setDiscount(rs.getDouble("discount"));
				article.setLocality(rs.getString("locality"));
				article.setPutawayDate(rs.getDate("putaway_Date"));
				article.setStorage(rs.getInt("storage"));
				article.setImage(rs.getString("image"));
				article.setDescription(rs.getString("description"));
				article.setTypeCode(rs.getString("type_code"));
				article.setCreateDate(rs.getDate("create_Date"));
				article.setDisabled(rs.getString("disabled"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ر���Դ
		close();
		return article;
	}
	
}
