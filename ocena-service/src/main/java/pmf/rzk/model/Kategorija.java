package pmf.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the kategorija database table.
 * 
 */
@Entity
@NamedQuery(name="Kategorija.findAll", query="SELECT k FROM Kategorija k")
public class Kategorija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkategorija;

	private String nazivKat;

	//bi-directional many-to-one association to Proizvod
	@JsonIgnore
	@OneToMany(mappedBy="kategorija")
	private List<Proizvod> proizvods;

	public Kategorija() {
	}

	public int getIdkategorija() {
		return this.idkategorija;
	}

	public void setIdkategorija(int idkategorija) {
		this.idkategorija = idkategorija;
	}

	public String getNazivKat() {
		return this.nazivKat;
	}

	public void setNazivKat(String nazivKat) {
		this.nazivKat = nazivKat;
	}

	public List<Proizvod> getProizvods() {
		return this.proizvods;
	}

	public void setProizvods(List<Proizvod> proizvods) {
		this.proizvods = proizvods;
	}

	public Proizvod addProizvod(Proizvod proizvod) {
		getProizvods().add(proizvod);
		proizvod.setKategorija(this);

		return proizvod;
	}

	public Proizvod removeProizvod(Proizvod proizvod) {
		getProizvods().remove(proizvod);
		proizvod.setKategorija(null);

		return proizvod;
	}

}