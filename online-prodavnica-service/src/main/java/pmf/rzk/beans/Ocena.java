package pmf.rzk.beans;



public class Ocena {
	
	private String komentar;
	private int ocena;
	private Proizvod proizvod;
	public Ocena() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ocena(String komentar, int ocena, Proizvod proizvod) {
		super();
		this.komentar = komentar;
		this.ocena = ocena;
		this.proizvod = proizvod;
	}
	public String getKomentar() {
		return komentar;
	}
	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	public Proizvod getProizvod() {
		return proizvod;
	}
	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}
	
	

}
