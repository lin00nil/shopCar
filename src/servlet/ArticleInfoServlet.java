package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Article;
import pojo.ArticleType;
import service.ArticleService;
import serviceImpl.ArticleServiceImpl;
import serviceImpl.ArticleTypeServiceImpl;

/**
 * Servlet implementation class ArticleInfoServlet
 */
@WebServlet("/ArticleInfoServlet")
public class ArticleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleService as = new ArticleServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		Article article= as.findById(id);
//		System.out.println(article);
		ArticleTypeServiceImpl articleTypeService = new ArticleTypeServiceImpl();
		//获取所有的一级物品类型
		List<ArticleType>  firstArticleTypes = articleTypeService.findAllFirstArticleType();
		request.setAttribute("article", article);
		request.setAttribute("firstArticleTypes", firstArticleTypes);
		//System.out.println(firstArticleTypes);
		request.getRequestDispatcher("WEB-INF/jsp/item.jsp").forward(request, response);
	}

}
