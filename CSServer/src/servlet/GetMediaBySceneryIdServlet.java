package servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GetMediaBySceneryId;
import dao.GetMediaBySceneryIdResponse;
import dao.SceneryDaoServiceStub;
import entity.xsd.Media;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class GetMediaBySceneryIdServlet
 */
@WebServlet(urlPatterns="/GetMediaBySceneryId", name="GetMediaBySceneryId")
public class GetMediaBySceneryIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMediaBySceneryIdServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		int sceneryId = Integer.parseInt(request.getParameter("sceneryId"));
		
		SceneryDaoServiceStub stub = new SceneryDaoServiceStub();
		GetMediaBySceneryId para = new GetMediaBySceneryId();
		GetMediaBySceneryIdResponse resp;
		
		para.setSceneryId(sceneryId);
		resp = stub.getMediaBySceneryId(para);
		Media[] mediaList = resp.get_return();
		
		JSONArray ja=JSONArray.fromObject(mediaList);
		String jsonReturn=ja.toString();
		
		OutputStream out = response.getOutputStream();
		out.write(jsonReturn.getBytes("UTF-8"));
	    System.out.println(jsonReturn);
	    out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
