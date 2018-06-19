package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.ArticleType;
import pojo.ShopCar;
import pojo.User;
import serviceImpl.ArticleTypeServiceImpl;
import serviceImpl.ShopCarServiceImpl;

/**
 * Servlet implementation class ShowShopCarItem
 */
@WebServlet("/ShowShopCarItem")
public class ShowShopCarItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowShopCarItem() {
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
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("session_user");
		System.out.println(user);
		if(user!=null){
			ArticleTypeServiceImpl articleTypeService = new ArticleTypeServiceImpl();
			//获取所有的一级物品类型
			List<ArticleType>  firstArticleTypes = articleTypeService.findAllFirstArticleType();
			ShopCarServiceImpl shopCarService=new ShopCarServiceImpl();
			List<ShopCar> shopCars=shopCarService.findShopCarByUserId(user.getId());
				
			System.out.println(user.getId());
			int num=0;
			for(ShopCar n:shopCars){
				System.out.println(n.getBuyNum()+" "+n.getUserId());
			}
			
			request.setAttribute("shopCars", shopCars);
			request.setAttribute("firstArticleTypes", firstArticleTypes);
			request.getRequestDispatcher("WEB-INF/jsp/shopCar.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("loginView").forward(request, response);
		}
		
	}

}
