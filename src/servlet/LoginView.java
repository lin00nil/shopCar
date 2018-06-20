package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.ArticleType;
import serviceImpl.ArticleTypeServiceImpl;

/**
 * Servlet implementation class loginService
 */
@WebServlet("/LoginView")
public class LoginView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginView() {
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
		ArticleTypeServiceImpl articleTypeService = new ArticleTypeServiceImpl();
		//获取所有的一级物品类型
		List<ArticleType>  firstArticleTypes = articleTypeService.findAllFirstArticleType();
		request.setAttribute("firstArticleTypes", firstArticleTypes);
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}

}
