package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GetSceneryListByOp;
import dao.GetSceneryListByOpResponse;
import dao.SceneryDaoServiceStub;
import dao.UpdateSceneryIcons;
import entity.xsd.SceneryWithInfo;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class GetSceneryListByOpServlet
 */
@WebServlet(urlPatterns = "/GetSceneryListByOp", name = "GetSceneryListByOp")
public class GetSceneryListByOpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetSceneryListByOpServlet() {
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

		int userId = Integer.parseInt(request.getParameter("userId"));
		int type = Integer.parseInt(request.getParameter("type"));

		try {
			SceneryDaoServiceStub stub = new SceneryDaoServiceStub();
			GetSceneryListByOp para = new GetSceneryListByOp();
			GetSceneryListByOpResponse resp;
			
			para.setType(type);
			para.setUserId(userId);
			resp = stub.getSceneryListByOp(para);
			SceneryWithInfo[] sceneryList = resp.get_return();
			
			//将数据格式转换为JSON数组
			JSONArray ja=JSONArray.fromObject(sceneryList);
			String jsonReturn=ja.toString();
			
			OutputStream out = response.getOutputStream();
			out.write(jsonReturn.getBytes("UTF-8"));
		    System.out.println(jsonReturn);
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
