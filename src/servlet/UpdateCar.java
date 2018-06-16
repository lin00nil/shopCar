package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;
import service.ShopCarService;
import serviceImpl.ShopCarServiceImpl;

/**
 * Servlet implementation class UpdateCar
 */
@WebServlet("/UpdateCar")
public class UpdateCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCar() {
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
		//用户
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("session_user");
		//商品id
		int id=Integer.parseInt(request.getParameter("id"));
		//购买数
		int buynum=Integer.parseInt(request.getParameter("buyNum"));
		ShopCarService sc=new ShopCarServiceImpl();
		int total=sc.updateShopCar(user.getId(), id, buynum);
		if(total==0){
			System.out.println("失败");
		}else{
			request.getRequestDispatcher("showShopCarItem").forward(request, response);
		}
	
	}

}
