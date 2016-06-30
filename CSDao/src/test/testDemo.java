package test;

import dao.SceneryDao;
import dao.UserDao;
import entity.CommentofUser;
import entity.Media;
import entity.Scenery;
import entity.SceneryWithInfo;
import entity.User;

public class testDemo {
	
	public static void main(String [] args) {
		SceneryDao dao = new SceneryDao();
//		Scenery[] s = dao.getSceneryList();
//		for(int i = 0; i<s.length; i++){
//			System.out.println(s[i].getName());
//		}
		
//		CommentofUser[] c = dao.getCommentListBySceneryId(1);
//		for(int i = 0; i < c.length; i++){
//			System.out.println(c[i].getCommentContent());
//			System.out.println(c[i].getCommentTime());
//			if(c[i].getCommentMedia() != null && c[i].getCommentMedia().getName() != null){
//				System.out.println(c[i].getCommentMedia().getName());
//			}
//			
//		}
		
		int s = dao.deleteOperation(1, 1, 0);
		System.out.println(s);
		
//		int r = dao.addOperationByIds(4, 4, 2);
//		System.out.println(r);
//		
//		Media[] mediaList = dao.getMediaBySceneryId(1);
//		for(int i = 0; i< mediaList.length; i++){
//			System.out.println(mediaList[i].getName());
//			System.out.println(mediaList[i].getType());
//		}
		
		//dao.addComment("还行", 1, 2, 3, "hehe.png");

		
		//dao.addHistory(1, 3);
//		dao.addHistory(3, 1);
		
//		SceneryWithInfo[] s = dao.getSceneryListByOp(1, 1);;
//		for(int i = 0; i < s.length; i++){
//			System.out.println("名字："+s[i].getScenery().getName());
//			System.out.println("得分："+ s[i].getScores()[0] + " " + s[i].getScores()[1] + " " + s[i].getScores()[2]+" "+s[i].getScores()[3]+" "+s[i].getScores()[4]);
//			System.out.println("收藏："+s[i].getCollection());
//			System.out.println("足迹："+s[i].getTrack());
//			System.out.println("心愿："+s[i].getWishlist());
//			System.out.println("边界："+s[i].getScenery().getBorder());
//			System.out.println("======================================");
//		}
		
//		UserDao dao = new UserDao();
//		User user = dao.register("123", "123456");
//		if(user != null)
//			System.out.println(user.getUserId());
//		else
//			System.out.println("null");
	}
	
	
}
