package pmf.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the racun database table.
 * 
 */
@Entity
@NamedQuery(name="Racun.findAll", query="SELECT r FROM Racun r")
public class Racun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idracun;

	private int stanje;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	public Racun() {
	}

	public int getIdracun() {
		return this.idracun;
	}

	public void setIdracun(int idracun) {
		this.idracun = idracun;
	}

	public int getStanje() {
		return this.stanje;
	}

	public void setStanje(int stanje) {
		this.stanje = stanje;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}