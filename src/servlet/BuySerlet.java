package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.ShopCar;
import pojo.User;
import service.ShopCarService;
import serviceImpl.ShopCarServiceImpl;

/**
 * Servlet implementation class BuySerlet
 */
@WebServlet("/buy.action")
public class BuySerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuySerlet() {
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
		if(user==null){
			request.getRequestDispatcher("loginView").forward(request, response);
		}else{
			int articleId=Integer.parseInt(request.getParameter("id"));
			int buyNum=Integer.parseInt(request.getParameter("buyNum"));
			int userId=user.getId();
			ShopCar shopcar=new ShopCar();
			shopcar.setArticleId(articleId);
			shopcar.setBuyNum(buyNum);
			shopcar.setUserId(userId);
			
			ShopCarService sI=new ShopCarServiceImpl();
			ShopCar shopcar2=new ShopCar();
			shopcar2=sI.findShopCarByAUId(shopcar);
			System.out.println(shopcar2);
			if(shopcar2==null){
				sI.add(shopcar);
			}else{
				buyNum+=shopcar.getBuyNum();
				shopcar.setBuyNum(buyNum);
				int total=sI.updateShopCar(shopcar);
			}
			request.getRequestDispatcher("showShopCarItem").forward(request, response);
		}
	}

}
