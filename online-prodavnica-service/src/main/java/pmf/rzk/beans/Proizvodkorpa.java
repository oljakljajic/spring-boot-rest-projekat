package pmf.rzk.beans;



public class Proizvodkorpa {
	
	private int kolicina;
	private Korpa korpa;
	private Proizvod proizvod;
	public Proizvodkorpa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Proizvodkorpa(int kolicina, Korpa korpa, Proizvod proizvod) {
		super();
		this.kolicina = kolicina;
		this.korpa = korpa;
		this.proizvod = proizvod;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public Korpa getKorpa() {
		return korpa;
	}
	public void setKorpa(Korpa korpa) {
		this.korpa = korpa;
	}
	public Proizvod getProizvod() {
		return proizvod;
	}
	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}
	
	

}
