package servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;
import service.UserService;
import serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//��ȡ����from�����ݣ�����һ��Name��Ӧstring����ļ���
		Map<String,String[]> form=request.getParameterMap();
		String name=form.get("loginName")[0];
		String pwd=form.get("password")[0];
		System.out.println(name);
		System.out.println(pwd);
		//��¼
		UserService service=new UserServiceImpl();
		User user=service.login(name, pwd);
		System.out.println(user);
		if(user!=null){
			//�ɹ�,ת��������
			  HttpSession session = request.getSession();
			 //�����ݴ洢��session��
			  session.setAttribute("session_user", user);
			request.getRequestDispatcher("indexServlet").forward(request, response);	
		}else{
			//���ɹ�
			//ת��������servlet
			request.getRequestDispatcher("RegisterView").forward(request, response);
		}
	}

}
