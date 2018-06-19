package pojo;

public class ShopCar implements java.io.Serializable{

	private int id;
	private int articleId;
	private int buyNum;
	private int userId;
	
	private Article article;
	
	
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public Integer getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "ShopCar [id=" + id + ", articleId=" + articleId + ", buyNum=" + buyNum + ", userId=" + userId
				+ ", article=" + article + "]";
	}
	
	
	
	
}