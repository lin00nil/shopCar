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
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
		request.setCharacterEncoding("utf-8");
		//获取请求参数
		String  typecode = request.getParameter("typecode");
		String  keyword = request.getParameter("keyword");
		System.out.println("typecode:"+typecode);
		System.out.println("keyword："+keyword);
		
		ArticleService articleService = new ArticleServiceImpl();
		ArticleTypeServiceImpl articleTypeService = new ArticleTypeServiceImpl();
		
		//获取所有的一级物品类型
		List<ArticleType>  firstArticleTypes = articleTypeService.findAllFirstArticleType();
		//首次打开首页，物品类型为null，默认加载第一个一级物品类型的商品
		if(typecode == null || typecode.equals("")){
			typecode = firstArticleTypes.get(0).getCode(); 
			System.out.println("typeCode:"+typecode);
		}
		//获取请求的一级物品类型，目的是展示在右边窗口左上角（如点击查询的是二级物品类型，则需截取前四位获取一级物品类型）
		String   firstArticleTypeCode = typecode.substring(0, 4);
		ArticleType  firstArticleType = articleTypeService.findFirstArticleTypeByCode(firstArticleTypeCode);
		
		System.out.println("firstArticleTypeCode==="+firstArticleTypeCode);
		System.out.println("firstArticleType=="+firstArticleType);	
		//获取请求的一级物品类型下所有的二级物品类型
		List<ArticleType>  allSecondArticleTypes = articleTypeService.findAllSecondArticleType(firstArticleTypeCode);
		System.out.println("allSecondArticleTypes====="+allSecondArticleTypes);
		
		//根据物品类型和关键字查询所有的商品
		List<Article>  articles = articleService.findByCodeAndKeyWord(keyword,typecode);
		for(Article a:articles){
			System.out.println(a);
		}
		
		request.setAttribute("articles", articles);	
		request.setAttribute("typecode", typecode);
		request.setAttribute("keyword", keyword);
		request.setAttribute("allSecondArticleTypes", allSecondArticleTypes);
		request.setAttribute("firstArticleType", firstArticleType);
		request.setAttribute("firstArticleTypes", firstArticleTypes);
		request.getRequestDispatcher("WEB-INF/jsp/list.jsp").forward(request, response);
	}

}
