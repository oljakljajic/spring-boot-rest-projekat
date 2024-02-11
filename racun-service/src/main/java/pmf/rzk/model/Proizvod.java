package pmf.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;
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

	private int cenaP;

	@Column(name="kategorija_idkategorija")
	private int kategorijaIdkategorija;

	private int kolicinaP;

	private String nazivP;

	private String opis;

	@Column(name="proizvodjac_idproizvodjac")
	private int proizvodjacIdproizvodjac;

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

	public int getKategorijaIdkategorija() {
		return this.kategorijaIdkategorija;
	}

	public void setKategorijaIdkategorija(int kategorijaIdkategorija) {
		this.kategorijaIdkategorija = kategorijaIdkategorija;
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

	public int getProizvodjacIdproizvodjac() {
		return this.proizvodjacIdproizvodjac;
	}

	public void setProizvodjacIdproizvodjac(int proizvodjacIdproizvodjac) {
		this.proizvodjacIdproizvodjac = proizvodjacIdproizvodjac;
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