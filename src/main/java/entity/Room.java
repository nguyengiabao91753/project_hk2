package entity;

public class Room {
	private int id;
	private String name;
	private int deparment_id;
	public Room() {}
	public Room(int id, String name, int deparment_id) {
		super();
		this.id = id;
		this.name = name;
		this.deparment_id = deparment_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeparment_id() {
		return deparment_id;
	}
	public void setDeparment_id(int deparment_id) {
		this.deparment_id = deparment_id;
	}
	@Override
	public String toString() {
		return name;
	}
	
	
	
}
