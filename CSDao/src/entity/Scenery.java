package entity;

public class Scenery {
	private int id;
	private String name;
	private String brief;
	private String detail;
	private float positionLatitude;
	private float positionLongitude;
	private int type;
	private String border;
	private String icons;
	
	public Scenery(){}
	
	public Scenery(int id,
			String name,
			String brief,
			String detail,
			float positionLatitude,
			float positionLongitude,
			int type,
			String border,
			String icons){
		this.id = id;
		this.name = name;
		this.brief = brief;
		this.detail = detail;
		this.positionLatitude = positionLatitude;
		this.positionLongitude = positionLongitude;
		this.type = type;
		this.border = border;
		this.icons = icons;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public float getPositionLatitude() {
		return positionLatitude;
	}
	public void setPositionLatitude(float positionLatitude) {
		this.positionLatitude = positionLatitude;
	}
	public float getPositionLongitude() {
		return positionLongitude;
	}
	public void setPositionLongitude(float positionLongitude) {
		this.positionLongitude = positionLongitude;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBorder() {
		return border;
	}

	public void setBorder(String border) {
		this.border = border;
	}

	public String getIcons() {
		return icons;
	}

	public void setIcons(String icons) {
		this.icons = icons;
	}
	
	
}
