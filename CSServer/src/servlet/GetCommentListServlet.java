package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GetCommentListBySceneryId;
import dao.GetCommentListBySceneryIdResponse;
import dao.GetSceneryListWithInfo;
import dao.GetSceneryListWithInfoResponse;
import dao.SceneryDaoServiceStub;
import entity.xsd.CommentofUser;
import entity.xsd.SceneryWithInfo;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class GetCommentListServlet
 */
@WebServlet(urlPatterns = "/GetCommentList", name = "GetCommentList")
public class GetCommentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCommentListServlet() {
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

		try {
			SceneryDaoServiceStub stub = new SceneryDaoServiceStub();
			GetCommentListBySceneryId para = new GetCommentListBySceneryId();
			GetCommentListBySceneryIdResponse resp;

			para.setSceneryId(sceneryId);
			resp = stub.getCommentListBySceneryId(para);
			CommentofUser[] commentList = resp.get_return();

			// 将数据格式转换为JSON数组
			JSONArray ja = JSONArray.fromObject(commentList);
			String jsonReturn = ja.toString();

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
