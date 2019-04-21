package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Login;
import DAO.LoginDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求编码
		request.setCharacterEncoding("utf-8");
		// 设置响应编码
		response.setContentType("utf-8");
		LoginDao loginDao = new LoginDao();
		HttpSession session = request.getSession();
		// 先获得user对象，如果是第一次访问该Servlet，用户对象肯定为空，
		//但如果是第二次甚至是第三次，就不应该再判断该用户的信息
		Login l = (Login) session.getAttribute("login");
		if (l == null)
			l = loginDao.checkLogin(request.getParameter("name"), request.getParameter("password"));
		if (l != null) {
			// 如果登陆成功
			session.setAttribute("login", l);
			// 将获取的对象保存在session中
			ArrayList al = loginDao.findMbInfo();
			// 获取留言板的内容，返回一个数组
			session.setAttribute("al", al);
			// 把数组保存起来
			response.sendRedirect("main.jsp");
			// 验证成功跳转到 main.jsp
		} else {
			// 验证失败跳转到 error.jsp
			response.sendRedirect("error.jsp");
		}
		if(session!=null) {
			response.sendRedirect("login.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
