package pojo;

public class ShopCar implements java.io.Serializable{

	private Integer id;
	private Integer articleId;
	private Integer buyNum;
	private Integer userId;
	
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
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public Integer getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "ShopCar [id=" + id + ", articleId=" + articleId + ", buyNum=" + buyNum + ", userId=" + userId
				+ ", article=" + article + "]";
	}
	
	
	
	
}