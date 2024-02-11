package pmf.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the proizvod database table.
 * 
 */
@Entity
@NamedQuery(name="Proizvod.findAll", query="SELECT p FROM Proizvod p")
public class Proizvod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproizvod;
	
	@Min(value = 500)
	private int cenaP;
	
	@Min(value = 1)
	private int kolicinaP;
	
	@Size(min = 1)
	private String nazivP;
	
	@Size(min = 1)
	private String opis;

	//bi-directional many-to-one association to Ocena
	@JsonIgnore
	@OneToMany(mappedBy="proizvod")
	private List<Ocena> ocenas;

	//bi-directional many-to-one association to Kategorija
	
	@ManyToOne
	@JoinColumn(name="kategorija_idkategorija")
	private Kategorija kategorija;

	//bi-directional many-to-one association to Proizvodjac
	@ManyToOne
	@JoinColumn(name="proizvodjac_idproizvodjac")
	private Proizvodjac proizvodjac;

	//bi-directional many-to-one association to Proizvodkorpa
	@JsonIgnore
	@OneToMany(mappedBy="proizvod")
	private List<Proizvodkorpa> proizvodkorpas;

	public Proizvod() {
	}

	public int getIdproizvod() {
		return this.idproizvod;
	}

	public void setIdproizvod(int idproizvod) {
		this.idproizvod = idproizvod;
	}

	public int getCenaP() {
		return this.cenaP;
	}

	public void setCenaP(int cenaP) {
		this.cenaP = cenaP;
	}

	public int getKolicinaP() {
		return this.kolicinaP;
	}

	public void setKolicinaP(int kolicinaP) {
		this.kolicinaP = kolicinaP;
	}

	public String getNazivP() {
		return this.nazivP;
	}

	public void setNazivP(String nazivP) {
		this.nazivP = nazivP;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Ocena> getOcenas() {
		return this.ocenas;
	}

	public void setOcenas(List<Ocena> ocenas) {
		this.ocenas = ocenas;
	}

	public Ocena addOcena(Ocena ocena) {
		getOcenas().add(ocena);
		ocena.setProizvod(this);

		return ocena;
	}

	public Ocena removeOcena(Ocena ocena) {
		getOcenas().remove(ocena);
		ocena.setProizvod(null);

		return ocena;
	}

	public Kategorija getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Proizvodjac getProizvodjac() {
		return this.proizvodjac;
	}

	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public List<Proizvodkorpa> getProizvodkorpas() {
		return this.proizvodkorpas;
	}

	public void setProizvodkorpas(List<Proizvodkorpa> proizvodkorpas) {
		this.proizvodkorpas = proizvodkorpas;
	}

	public Proizvodkorpa addProizvodkorpa(Proizvodkorpa proizvodkorpa) {
		getProizvodkorpas().add(proizvodkorpa);
		proizvodkorpa.setProizvod(this);

		return proizvodkorpa;
	}

	public Proizvodkorpa removeProizvodkorpa(Proizvodkorpa proizvodkorpa) {
		getProizvodkorpas().remove(proizvodkorpa);
		proizvodkorpa.setProizvod(null);

		return proizvodkorpa;
	}

}