package pmf.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkorisnika;

	private String ime;

	private String password;

	private String prezime;

	private String username;

	//bi-directional many-to-one association to Korisnikauloga
	@JsonIgnore
	@OneToMany(mappedBy="korisnik")
	private List<Korisnikauloga> korisnikaulogas;

	//bi-directional many-to-one association to Racun
	@JsonIgnore
	@OneToMany(mappedBy="korisnik")
	private List<Racun> racuns;

	//bi-directional many-to-one association to Korpa
	@JsonIgnore
	@OneToMany(mappedBy="korisnik")
	private List<Korpa> korpas;

	public Korisnik() {
	}

	public int getIdkorisnika() {
		return this.idkorisnika;
	}

	public void setIdkorisnika(int idkorisnika) {
		this.idkorisnika = idkorisnika;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Korisnikauloga> getKorisnikaulogas() {
		return this.korisnikaulogas;
	}

	public void setKorisnikaulogas(List<Korisnikauloga> korisnikaulogas) {
		this.korisnikaulogas = korisnikaulogas;
	}

	public Korisnikauloga addKorisnikauloga(Korisnikauloga korisnikauloga) {
		getKorisnikaulogas().add(korisnikauloga);
		korisnikauloga.setKorisnik(this);

		return korisnikauloga;
	}

	public Korisnikauloga removeKorisnikauloga(Korisnikauloga korisnikauloga) {
		getKorisnikaulogas().remove(korisnikauloga);
		korisnikauloga.setKorisnik(null);

		return korisnikauloga;
	}

	public List<Racun> getRacuns() {
		return this.racuns;
	}

	public void setRacuns(List<Racun> racuns) {
		this.racuns = racuns;
	}

	public Racun addRacun(Racun racun) {
		getRacuns().add(racun);
		racun.setKorisnik(this);

		return racun;
	}

	public Racun removeRacun(Racun racun) {
		getRacuns().remove(racun);
		racun.setKorisnik(null);

		return racun;
	}

	public List<Korpa> getKorpas() {
		return this.korpas;
	}

	public void setKorpas(List<Korpa> korpas) {
		this.korpas = korpas;
	}

	public Korpa addKorpa(Korpa korpa) {
		getKorpas().add(korpa);
		korpa.setKorisnik(this);

		return korpa;
	}

	public Korpa removeKorpa(Korpa korpa) {
		getKorpas().remove(korpa);
		korpa.setKorisnik(null);

		return korpa;
	}

}