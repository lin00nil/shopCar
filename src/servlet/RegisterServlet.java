package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import service.UserService;
import serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		//获取整个from表单数据，返回一个Name对应string数组的集合
		Map<String,String[]> form=request.getParameterMap();
		String loginName=form.get("loginName")[0];
		String pwd=form.get("passWord")[0];
		String name=form.get("name")[0];
		String sex=form.get("sex")[0];
		String address=form.get("address")[0];//这一行报错 .NullPointerException是指空指针，说明没有这个变量
		String phone=form.get("phone")[0];
		String authcode=form.get("authcode")[0];
		Date now=new Date();
		System.out.println(name);
		System.out.println(loginName);
		
		// 验证验证码
        String sessionCode = request.getSession().getAttribute("code").toString();
        if (authcode != null && !"".equals(authcode) && sessionCode != null && !"".equals(sessionCode)) {
            if (authcode.equalsIgnoreCase(sessionCode)) {
                //response.getWriter().println("验证通过！");
            	User user=new User();
            	user.setName(name);
            	user.setpassword(pwd);
            	user.setLoginName(loginName);
            	user.setSex(Integer.parseInt(sex));
            	user.setEmail(loginName);
            	user.setAddress(address);
            	user.setPhone(phone);
            	user.setCreateDate(now);
            	UserService service=new UserServiceImpl();
            	service.addUser(user);
            	request.getRequestDispatcher("loginView").forward(request, response);
            } else {
                //response.getWriter().println("验证失败！");
            	//提示注册失败,验证码错误
            	response.setContentType("text/plain; charset=utf-8"); 
            	response.getWriter().println("验证失败！");
            }
        } else {
            //response.getWriter().println("验证失败！");
        	//提示注册失败，验证码错误
        	response.setContentType("text/plain; charset=utf-8"); 
        	response.getWriter().println("验证失败！");
        }
		
//		if(pwd.equals(comfirmPwd)){
//			//注册
//			UserService service=new UserServiceImpl();
//			User user=new User();
//			user.setName(name);
//			user.setPwd(pwd);
//			user.setAddress(address);
//
//			service.addUser(user);
//			request.getRequestDispatcher("loginView").forward(request, response);
//		}else{
//			System.out.println("密码不同");
//		}

	
	}

}
