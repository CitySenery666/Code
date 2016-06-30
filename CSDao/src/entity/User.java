package entity;

public class User {
	private int userId;
	private String userName;
	private String userPortrait;
	
	public User(){}
	
	public User(int userId, String userName, String userPortrait){
		this.userId = userId;
		this.userName = userName;
		this.userPortrait = userPortrait;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPortrait() {
		return userPortrait;
	}
	public void setUserPortrait(String userPortrait) {
		this.userPortrait = userPortrait;
	}
	
}
