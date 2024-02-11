package pmf.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the korisnikauloga database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnikauloga.findAll", query="SELECT k FROM Korisnikauloga k")
public class Korisnikauloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkorisnikauloga;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnika_idkorisnika")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Uloga
	@ManyToOne
	private Uloga uloga;

	public Korisnikauloga() {
	}

	public int getIdkorisnikauloga() {
		return this.idkorisnikauloga;
	}

	public void setIdkorisnikauloga(int idkorisnikauloga) {
		this.idkorisnikauloga = idkorisnikauloga;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

}