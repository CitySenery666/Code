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
import dao.UpdateSceneryIcons;

/**
 * Servlet implementation class UpdateSceneryIconsServlet
 */
@WebServlet(urlPatterns="/UpdateSceneryIcons", name="UpdateSceneryIcons")
public class UpdateSceneryIconsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSceneryIconsServlet() {
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
		String icons = request.getParameter("icons");
		
		try {
			SceneryDaoServiceStub stub = new SceneryDaoServiceStub();
			UpdateSceneryIcons para = new UpdateSceneryIcons();
			para.setSceneryId(sceneryId);
			para.setIcons(icons);

			stub.updateSceneryIcons(para);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
