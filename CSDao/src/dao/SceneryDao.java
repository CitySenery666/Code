package dao;

import java.lang.Thread.State;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.text.html.MinimalHTMLWriter;

import entity.CommentofUser;
import entity.Media;
import entity.Scenery;
import entity.SceneryWithInfo;
import entity.User;
import util.DatabaseLink;

public class SceneryDao {

	// type mapping:
	// operation 的类型： 0: 收藏 1: 足迹 2: 心愿
	// 景观的类型： 0:热门景点 1:普通景点 2:没人去的景点

	// 返回景观列表，包括景观的名字，地址，简介，详情，和景观的类型；
	public Scenery[] getSceneryList() {
		ArrayList<Scenery> sceneryList = new ArrayList<Scenery>();
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "SELECT * FROM `scenery`";

		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				ResultSet rs = stat.executeQuery();
				while (rs.next()) {
					sceneryList.add(new Scenery(rs.getInt("scenery_id"), rs.getString("scenery_name"),
							rs.getString("scenery_brief"), rs.getString("scenery_detail"),
							rs.getFloat("scenery_latitude"), rs.getFloat("scenery_longitude"),
							rs.getInt("scenery_type"), rs.getString("scenery_border"), rs.getString("scenery_icons")));
				}
				rs.close();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Scenery[] ret = new Scenery[sceneryList.size()];
		sceneryList.toArray(ret);
		return ret;
	}

	// 返回单个景观信息，包括名字，简介，详情，坐标和类型
	public Scenery getSceneryById(int sceneryId) {
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "SELECT * FROM `scenery` WHERE scenery_id=?";
		Scenery ret = null;
		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				stat.setInt(1, sceneryId);
				ResultSet rs = stat.executeQuery();
				while (rs.next()) {
					ret = new Scenery(rs.getInt("scenery_id"), rs.getString("scenery_name"),
							rs.getString("scenery_brief"), rs.getString("scenery_detail"),
							rs.getFloat("scenery_latitude"), rs.getFloat("scenery_longitude"),
							rs.getInt("scenery_type"), rs.getString("scenery_border"), rs.getString("scenery_icons"));
				}
				rs.close();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ret;
		}
	}

	// 根据id返回景观的得分，分别为1，2，3，4，5分的打分数
	public int[] getScoresBySceneryId(int sceneryId) {
		int[] scores = new int[5];
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "SELECT COUNT('comment_score') FROM `comment` WHERE scenery_id=? AND comment_score=?";

		for (int i = 0; i < 5; i++) {
			synchronized (conn) {
				try {
					PreparedStatement stat = conn.prepareStatement(pstStr);
					stat.setInt(1, sceneryId);
					stat.setInt(2, i + 1);
					ResultSet rs = stat.executeQuery();
					while (rs.next()) {
						scores[i] = rs.getInt(1);
					}
					rs.close();
					stat.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return scores;
	}

	// 获取某个景观被收藏／足迹／心愿的数量
	public int getNumberOfOperation(int sceneryId, int type) {
		int ret = 0;
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "SELECT COUNT('user_id') FROM `operation` WHERE scenery_id=? AND operation_type=?";
		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				stat.setInt(1, sceneryId);
				stat.setInt(2, type);
				ResultSet rs = stat.executeQuery();
				while (rs.next()) {
					ret = rs.getInt(1);
				}
				rs.close();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	// 用户收藏／足迹／心愿操作
	public int addOperationByIds(int sceneryId, int userId, int type) {
		int ret = -1;
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "SELECT * FROM `operation` WHERE user_id=? AND scenery_id=? AND operation_type=?";
		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				stat.setInt(1, userId);
				stat.setInt(2, sceneryId);
				stat.setInt(3, type);

				ResultSet rs = stat.executeQuery();
				if (rs.next()) {
					ret = 0;
				} else {
					stat.close();
					String newStr = "INSERT INTO `operation` (user_id, scenery_id, operation_type) VALUES (?,?,?)";
					stat = conn.prepareStatement(newStr);
					stat.setInt(1, userId);
					stat.setInt(2, sceneryId);
					stat.setInt(3, type);
					stat.execute();
					ret = 1;
				}
				stat.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	// 获取一个景观中所有的照片和视频
	public Media[] getMediaBySceneryId(int sceneryId) {
		ArrayList<Media> mediaList = new ArrayList<Media>();
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "SELECT comment_media FROM `comment` WHERE scenery_id=?";
		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				stat.setInt(1, sceneryId);
				ResultSet rs = stat.executeQuery();
				String test = "mp4";
				while (rs.next()) {
					if (rs.getString(1) != null && !rs.getString(1).equals(""))
						if (rs.getString(1).indexOf(test) >= 0)
							mediaList.add(new Media(rs.getString(1), 1));
						else
							mediaList.add(new Media(rs.getString(1), 0));
				}
				rs.close();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Media[] ret = new Media[mediaList.size()];
		mediaList.toArray(ret);
		return ret;
	}

	// 获取某个景观的所有点评
	public CommentofUser[] getCommentListBySceneryId(int sceneryId) {
		ArrayList<CommentofUser> commentList = new ArrayList<CommentofUser>();
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "SELECT * FROM `comment` WHERE scenery_id=? ORDER BY comment_id DESC";
		UserDao dao = new UserDao();
		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				stat.setInt(1, sceneryId);
				ResultSet rs = stat.executeQuery();
				String test = "mp4";
				while (rs.next()) {
					int userId = rs.getInt("user_id");
					User user = dao.getUserById(userId);
					Media media = null;
					String getStr = rs.getString("comment_media");
					if (getStr != null && !getStr.equals(""))
						if (getStr.indexOf(test) >= 0)
							media = new Media(getStr, 1);
						else
							media = new Media(getStr, 0);

					CommentofUser comment = new CommentofUser(user, rs.getString("comment_content"),
							rs.getTimestamp("comment_time").getTime(), rs.getInt("comment_score"), media);
					commentList.add(comment);
				}
				rs.close();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		CommentofUser[] ret = new CommentofUser[commentList.size()];
		commentList.toArray(ret);
		return ret;
	}

	// 获取有评分和收藏、足迹、心愿信息的景观列表
	public SceneryWithInfo[] getSceneryListWithInfo() {
		ArrayList<SceneryWithInfo> sceneryWithInfoList = new ArrayList<SceneryWithInfo>();
		Scenery[] sceneryList = getSceneryList();
		for (int i = 0; i < sceneryList.length; i++) {
			int sceneryId = sceneryList[i].getId();
			SceneryWithInfo s = getSceneryWithInfoById(sceneryId);
			sceneryWithInfoList.add(s);
		}
		SceneryWithInfo[] ret = new SceneryWithInfo[sceneryWithInfoList.size()];
		sceneryWithInfoList.toArray(ret);
		return ret;
	}

	// 通过景观id获取景观详细信息
	public SceneryWithInfo getSceneryWithInfoById(int sceneryId) {
		Scenery scenery = getSceneryById(sceneryId);
		int[] scores = getScoresBySceneryId(sceneryId);
		int collection = getNumberOfOperation(sceneryId, 0);
		int track = getNumberOfOperation(sceneryId, 1);
		int wishlist = getNumberOfOperation(sceneryId, 2);
		SceneryWithInfo ret = new SceneryWithInfo(scenery, scores, collection, track, wishlist);
		return ret;
	}

	// 通过用户id获取用户搜索历史，返回所有搜索过的景观列表，包含景观的详细信息
	public SceneryWithInfo[] getHistoryListByUserId(int userId) {
		ArrayList<SceneryWithInfo> sceneryWithInfoList = new ArrayList<SceneryWithInfo>();
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "SELECT scenery_id FROM `history` WHERE user_id=?";

		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				stat.setInt(1, userId);
				ResultSet rs = stat.executeQuery();
				while (rs.next()) {
					sceneryWithInfoList.add(getSceneryWithInfoById(rs.getInt(1)));
				}
				rs.close();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		SceneryWithInfo[] ret = new SceneryWithInfo[sceneryWithInfoList.size()];
		sceneryWithInfoList.toArray(ret);
		return ret;
	}

	// 通过用户id和景观id添加搜索记录
	public int addHistory(int userId, int sceneryId) {
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "SELECT * FROM `history` WHERE scenery_id=? AND user_id=?";
		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				stat.setInt(1, sceneryId);
				stat.setInt(2, userId);
				ResultSet rs = stat.executeQuery();
				if (rs.next()) {
					rs.close();
					stat.close();
					return 0;
				} else {
					rs.close();
					stat.close();
					String newStr = "INSERT into `history` (scenery_id, user_id) VALUES (?,?)";
					stat = conn.prepareStatement(newStr);
					stat.setInt(1, sceneryId);
					stat.setInt(2, userId);
					stat.execute();
					stat.close();
					return 1;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
		}
	}

	// 添加一条评论
	public int addComment(String content, int userId, int sceneryId, int score, String media) {
		Connection conn = DatabaseLink.getInstance().getConn();
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String pstStr = "INSERT INTO `comment` (scenery_id, user_id, comment_content, comment_time, comment_score, comment_media) VALUES"
				+ "('" + sceneryId + "', '" + userId + "', '" + content + "', '" + time + "', '" + score + "', '"
				+ media + "')";
		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				stat.execute();
				stat.close();
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
		}
	}

	// 更新景观的图标
	public int updateSceneryIcons(int sceneryId, String icons) {
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "UPDATE `scenery` SET scenery_icons='" + icons + "' WHERE scenery_id='" + sceneryId + "'";
		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				stat.execute();
				stat.close();
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
		}
	}

	// 获取某个用户某个操作的所有景观列表
	public SceneryWithInfo[] getSceneryListByOp(int userId, int type) {
		ArrayList<SceneryWithInfo> sceneryList = new ArrayList<SceneryWithInfo>();
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "SELECT scenery_id FROM `operation` WHERE user_id=? AND operation_type=?";
		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				stat.setInt(1, userId);
				stat.setInt(2, type);
				ResultSet rs = stat.executeQuery();
				while (rs.next()) {
					sceneryList.add(getSceneryWithInfoById(rs.getInt(1)));
				}
				rs.close();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		SceneryWithInfo[] ret = new SceneryWithInfo[sceneryList.size()];
		sceneryList.toArray(ret);
		return ret;

	}

	// 删除用户对某个景点的操作
	public int deleteOperation(int userId, int sceneryId, int type) {
		Connection conn = DatabaseLink.getInstance().getConn();
		String pstStr = "DELETE FROM `operation` where user_id=? AND scenery_id=? AND operation_type=?";
		synchronized (conn) {
			try {
				PreparedStatement stat = conn.prepareStatement(pstStr);
				stat.setInt(1, userId);
				stat.setInt(2, sceneryId);
				stat.setInt(3, type);
				stat.execute();
				stat.close();
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
		}
	}

}
