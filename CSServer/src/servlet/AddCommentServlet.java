package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import dao.AddComment;
import dao.SceneryDaoServiceStub;

/**
 * Servlet implementation class AddCommentServlet
 */
@WebServlet(urlPatterns = "/AddComment", name = "AddComment")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCommentServlet() {
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

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);

		int userId = 0;
		int sceneryId = 0;
		String media = "";
		String content = "";
		int score = 0;

		List<FileItem> fileItems;
		try {
			fileItems = sfu.parseRequest(new ServletRequestContext(request));
			FileItem item0 = fileItems.get(0);
			String t = item0.getFieldName();
			if (t != null && item0.isFormField() && t.equals("userId")) {
				userId = Integer.parseInt(item0.getString());
			}

			FileItem item1 = fileItems.get(1);
			t = item1.getFieldName();
			if (t != null && item1.isFormField() && t.equals("sceneryId")) {
				sceneryId = Integer.parseInt(item1.getString());
			}

			FileItem item2 = fileItems.get(2);
			String name = item2.getFieldName();
			if (name != null && userId != 0 && name.equals("media")) {
				String fileName = item2.getName();
				if (fileName != null && !fileName.equals("")) {
					fileName = fileName.substring(fileName.lastIndexOf("."));
					if (null != fileName && !("".equals(fileName))) {
						ServletContext sctx = getServletContext();
						String path = sctx.getRealPath("img/comment/");
						Date date = new Date();
						Long d = date.getTime();
						File file = new File(path + d + fileName);
						item2.write(file);
						media = file.getName();
					}
				}
			}

			FileItem item3 = fileItems.get(3);
			name = item3.getFieldName();
			if (name != null && userId != 0 && name.equals("commentContent")) {
				String temp = item3.getString();
				content = new String(temp.getBytes("iso-8859-1"), "utf-8");
			}

			FileItem item4 = fileItems.get(4);
			name = item4.getFieldName();
			if (name != null && userId != 0 && name.equals("score")) {
				score = Integer.parseInt(item4.getString());
			}

			SceneryDaoServiceStub stub = new SceneryDaoServiceStub();
			AddComment para = new AddComment();

			para.setUserId(userId);
			para.setSceneryId(sceneryId);
			para.setContent(content);
			para.setScore(score);
			para.setMedia(media);

			stub.addComment(para);

		} catch (Exception e) {
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
