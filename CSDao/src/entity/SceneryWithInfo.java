package entity;

public class SceneryWithInfo {
	
	private Scenery scenery;
	private int[] scores;//得分
	private int collection;//收藏
	private int track;//足迹
	private int wishlist;//心愿
	
	public SceneryWithInfo(){}
	public SceneryWithInfo(Scenery scenery, 
			int[] scores,
			int collection,
			int track,
			int wishlist){
		this.scenery = scenery;
		this.scores = scores;
		this.collection = collection;
		this.track = track;
		this.wishlist = wishlist;
	}
	
	public Scenery getScenery() {
		return scenery;
	}
	public void setScenery(Scenery scenery) {
		this.scenery = scenery;
	}
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	public int getCollection() {
		return collection;
	}
	public void setCollection(int collection) {
		this.collection = collection;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public int getWishlist() {
		return wishlist;
	}
	public void setWishlist(int wishlist) {
		this.wishlist = wishlist;
	}
}
