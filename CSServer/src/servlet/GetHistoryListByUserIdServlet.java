package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GetHistoryListByUserId;
import dao.GetHistoryListByUserIdResponse;
import dao.SceneryDaoServiceStub;
import entity.xsd.SceneryWithInfo;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class GetHistoryListByUserIdServlet
 */
@WebServlet(urlPatterns="/GetHistoryListByUserId", name="GetHistoryListByUserId")
public class GetHistoryListByUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHistoryListByUserIdServlet() {
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
		
		try {
			SceneryDaoServiceStub stub = new SceneryDaoServiceStub();
			GetHistoryListByUserId para = new GetHistoryListByUserId();
			GetHistoryListByUserIdResponse resp;
			
			para.setUserId(userId);
			resp = stub.getHistoryListByUserId(para);
			SceneryWithInfo[] historyList = resp.get_return();
			
			//将数据格式转换为JSON数组
			JSONArray ja=JSONArray.fromObject(historyList);
			String jsonReturn=ja.toString();
			
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
