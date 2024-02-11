package pmf.rzk.excaption;


public class ErrorDetails {
	
	private String massage;
	
	private int id;

	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(String massage, int id) {
		super();
		this.massage = massage;
		this.id = id;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}

