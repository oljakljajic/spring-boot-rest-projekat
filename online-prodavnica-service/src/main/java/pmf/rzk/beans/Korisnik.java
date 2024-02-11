package pmf.rzk.beans;

public class Korisnik {
	
	private String ime;
	private String password;
	private String prezime;
	private String username;
	public Korisnik() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Korisnik(String ime, String password, String prezime, String username) {
		super();
		this.ime = ime;
		this.password = password;
		this.prezime = prezime;
		this.username = username;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
