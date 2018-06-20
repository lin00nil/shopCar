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
 * Servlet implementation class DeleteCar
 */
@WebServlet("/deleteCar.action")
public class DeleteCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCar() {
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
		int articleId=Integer.parseInt(request.getParameter("id"));
		ShopCarService scs=new ShopCarServiceImpl();
		scs.deleteByAUId(articleId,user.getId());
		request.getRequestDispatcher("ShowShopCarItem").forward(request, response);
	}

}
