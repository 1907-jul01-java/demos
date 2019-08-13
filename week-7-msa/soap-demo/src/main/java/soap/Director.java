package soap;

public class Director {
	private int id;
	private String name;

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

	@Override
	public String toString() {
		return "Director [id=" + id + ", name=" + name + "]";
	}

	public Director(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Director() {
		super();
	}

}