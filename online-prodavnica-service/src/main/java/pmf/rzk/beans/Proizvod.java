package pmf.rzk.beans;

public class Proizvod {
	
	private String nazivP;
	private int cenaP;
	private int kolicinaP;
	private String opis;
	private Kategorija kategorija;
	private Proizvodjac proizvodjac;
	
	
	
	public Proizvod() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Proizvod(String nazivP, int cenaP, int kolicinaP, String opis, Kategorija kategorija,
			Proizvodjac proizvodjac) {
		super();
		this.nazivP = nazivP;
		this.cenaP = cenaP;
		this.kolicinaP = kolicinaP;
		this.opis = opis;
		this.kategorija = kategorija;
		this.proizvodjac = proizvodjac;
	}



	public String getNazivP() {
		return nazivP;
	}



	public void setNazivP(String nazivP) {
		this.nazivP = nazivP;
	}



	public int getCenaP() {
		return cenaP;
	}



	public void setCenaP(int cenaP) {
		this.cenaP = cenaP;
	}



	public int getKolicinaP() {
		return kolicinaP;
	}



	public void setKolicinaP(int kolicinaP) {
		this.kolicinaP = kolicinaP;
	}



	public String getOpis() {
		return opis;
	}



	public void setOpis(String opis) {
		this.opis = opis;
	}



	public Kategorija getKategorija() {
		return kategorija;
	}



	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}



	public Proizvodjac getProizvodjac() {
		return proizvodjac;
	}



	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	
	
	
	

}
