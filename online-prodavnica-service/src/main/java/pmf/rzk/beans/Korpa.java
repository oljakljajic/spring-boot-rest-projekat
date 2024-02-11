package pmf.rzk.beans;

import java.util.Date;

public class Korpa {
	
	private Date datumNarudzbine;
	private Korisnik korisnik;
	public Korpa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Korpa(Date datumNarudzbine, Korisnik korisnik) {
		super();
		this.datumNarudzbine = datumNarudzbine;
		this.korisnik = korisnik;
	}
	public Date getDatumNarudzbine() {
		return datumNarudzbine;
	}
	public void setDatumNarudzbine(Date datumNarudzbine) {
		this.datumNarudzbine = datumNarudzbine;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	

}
