package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.Login;
import dao.LoginResponse;
import dao.UserDaoServiceStub;
import entity.xsd.User;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet(urlPatterns="/UserLogin", name="UserLogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		
		try {
			UserDaoServiceStub stub = new UserDaoServiceStub();
			Login para = new Login();
			LoginResponse resp;
			
			para.setUserName(userName);
			para.setUserPassword(userPassword);
			
			resp = stub.login(para);
			User user= resp.get_return();
			JSONArray ja = JSONArray.fromObject(user);
			String jsonReturn = ja.toString();

			OutputStream out = response.getOutputStream();
			out.write(jsonReturn.getBytes("UTF-8"));
			System.out.println(jsonReturn);
			out.flush();
			out.close();
			
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
