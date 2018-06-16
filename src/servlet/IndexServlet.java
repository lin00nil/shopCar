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
		//��ȡ�������
		String  typecode = request.getParameter("typecode");
		String  keyword = request.getParameter("keyword");
		System.out.println("typecode:"+typecode);
		System.out.println("keyword��"+keyword);
		
		ArticleService articleService = new ArticleServiceImpl();
		ArticleTypeServiceImpl articleTypeService = new ArticleTypeServiceImpl();
		
		//��ȡ���е�һ����Ʒ����
		List<ArticleType>  firstArticleTypes = articleTypeService.findAllFirstArticleType();
		//�״δ���ҳ����Ʒ����Ϊnull��Ĭ�ϼ��ص�һ��һ����Ʒ���͵���Ʒ
		if(typecode == null || typecode.equals("")){
			typecode = firstArticleTypes.get(0).getCode(); 
			System.out.println("typeCode:"+typecode);
		}
		//��ȡ�����һ����Ʒ���ͣ�Ŀ����չʾ���ұߴ������Ͻǣ�������ѯ���Ƕ�����Ʒ���ͣ������ȡǰ��λ��ȡһ����Ʒ���ͣ�
		String   firstArticleTypeCode = typecode.substring(0, 4);
		ArticleType  firstArticleType = articleTypeService.findFirstArticleTypeByCode(firstArticleTypeCode);
		
		System.out.println("firstArticleTypeCode==="+firstArticleTypeCode);
		System.out.println("firstArticleType=="+firstArticleType);	
		//��ȡ�����һ����Ʒ���������еĶ�����Ʒ����
		List<ArticleType>  allSecondArticleTypes = articleTypeService.findAllSecondArticleType(firstArticleTypeCode);
		System.out.println("allSecondArticleTypes====="+allSecondArticleTypes);
		
		//������Ʒ���ͺ͹ؼ��ֲ�ѯ���е���Ʒ
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
