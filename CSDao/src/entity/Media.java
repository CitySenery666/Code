package entity;

public class Media {
	private String name;
	private int type;
	
	public Media(){}
	public Media(String name,
			int type){
		this.setName(name);
		this.setType(type);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
