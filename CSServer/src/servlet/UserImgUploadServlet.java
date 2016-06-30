package servlet;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.mysql.jdbc.UpdatableResultSet;

import dao.UpdateUserImg;
import dao.UpdateUserImgResponse;
import dao.UserDaoServiceStub;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class UserImgUploadServlet
 */
@WebServlet(name = "UserImgUpload", urlPatterns = { "/UserImgUpload" })
public class UserImgUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserImgUploadServlet() {
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
		String icon = "";
		try {

			sfu.setFileSizeMax(1024 * 50 * 1024);
			List<FileItem> fileItems = sfu.parseRequest(new ServletRequestContext(request));
			FileItem i = fileItems.get(0);
			String t = i.getFieldName();
			if (t != null && i.isFormField() && t.equals("userId")) {
				userId = Integer.parseInt(i.getString());
			}

			FileItem item = fileItems.get(1);
			String name = item.getFieldName();
			if (name != null && userId != 0 && name.equals("picture")) {
				String fileName = item.getName();
				fileName = fileName.substring(fileName.lastIndexOf("."));
				if (null != fileName && !("".equals(fileName))) {
					ServletContext sctx = getServletContext();
					String path = sctx.getRealPath("img/user/");// 头像目录
					Date date = new Date();
					Long d = date.getTime();
					File file = new File(path + d + fileName);
					item.write(file);
					icon = file.getName();
				}
			}
			
			UserDaoServiceStub stub = new UserDaoServiceStub();
			UpdateUserImg para = new UpdateUserImg();
			
			para.setFilename(icon);
			para.setUserId(userId);
			
			stub.updateUserImg(para);

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
