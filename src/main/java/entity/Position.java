package entity;

public class Position {
	private int id ;
	private String position_name;
	
	public Position() {
		
	}

	public Position(int id, String position_name) {
		super();
		this.id = id;
		this.position_name = position_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", position_name=" + position_name + "]";
	}
	
	
}
