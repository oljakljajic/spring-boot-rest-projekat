package pmf.rzk.beans;



public class Racun {
	
	private int stanje;
	private Korisnik korisnik;
	public Racun() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Racun(int stanje, Korisnik korisnik) {
		super();
		this.stanje = stanje;
		this.korisnik = korisnik;
	}
	public int getStanje() {
		return stanje;
	}
	public void setStanje(int stanje) {
		this.stanje = stanje;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	

}
