package entity;

public class CommentofUser {
	
	private User user;
	private String commentContent;
	private long commentTime;
	private int commentScore;
	private Media commentMedia;
	
	public CommentofUser(){}
	
	public CommentofUser(
			User user,
			String commentContent,
			long commentTime,
			int commentScore,
			Media commentMedia){
		this.user=user;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
		this.commentScore = commentScore;
		this.commentMedia = commentMedia;
	}
	
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public int getCommentScore() {
		return commentScore;
	}
	public void setCommentScore(int commentScore) {
		this.commentScore = commentScore;
	}
	public long getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(long commentTime) {
		this.commentTime = commentTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Media getCommentMedia() {
		return commentMedia;
	}

	public void setCommentMedia(Media commentMedia) {
		this.commentMedia = commentMedia;
	}
}
