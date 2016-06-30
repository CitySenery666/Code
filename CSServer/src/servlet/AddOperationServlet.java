package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddOperationByIds;
import dao.AddOperationByIdsResponse;
import dao.SceneryDaoServiceStub;

/**
 * Servlet implementation class AddOperationServlet
 */
@WebServlet(urlPatterns = "/AddOperation", name = "AddOperation")
public class AddOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddOperationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");

		int sceneryId = Integer.parseInt(request.getParameter("sceneryId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int type = Integer.parseInt(request.getParameter("type"));

		try {
			SceneryDaoServiceStub stub = new SceneryDaoServiceStub();
			AddOperationByIds para = new AddOperationByIds();
			AddOperationByIdsResponse resp;

			para.setSceneryId(sceneryId);
			para.setUserId(userId);
			para.setType(type);

			resp = stub.addOperationByIds(para);
			int right = resp.get_return();
			String retStr = "0";
			if (right == 1) {
				retStr = "1";
			}
			String jsonReturn = "{\"flag\":\"" + retStr + "\"}";
			OutputStream out = response.getOutputStream();
			out.write(jsonReturn.getBytes("UTF-8"));
			out.flush();
			out.close();

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
