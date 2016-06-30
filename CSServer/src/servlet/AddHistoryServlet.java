package servlet;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddHistory;
import dao.SceneryDaoServiceStub;

/**
 * Servlet implementation class AddHistoryServlet
 */
@WebServlet(urlPatterns="/AddHistory", name="AddHistory")
public class AddHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHistoryServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		int sceneryId = Integer.parseInt(request.getParameter("sceneryId"));
		
		try {
		SceneryDaoServiceStub stub = new SceneryDaoServiceStub();
		AddHistory para = new AddHistory();
		para.setUserId(userId);
		para.setSceneryId(sceneryId);
		
		stub.addHistory(para);
		
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
