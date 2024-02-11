package pmf.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the proizvodjac database table.
 * 
 */
@Entity
@NamedQuery(name="Proizvodjac.findAll", query="SELECT p FROM Proizvodjac p")
public class Proizvodjac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproizvodjac;
	
	@Size(min = 5)
	private String adresaProizvodjaca;
	@Size(min = 2)
	private String imeProizvodjaca;

	//bi-directional many-to-one association to Proizvod
	@JsonIgnore
	@OneToMany(mappedBy="proizvodjac")
	private List<Proizvod> proizvods;

	public Proizvodjac() {
	}

	public int getIdproizvodjac() {
		return this.idproizvodjac;
	}

	public void setIdproizvodjac(int idproizvodjac) {
		this.idproizvodjac = idproizvodjac;
	}

	public String getAdresaProizvodjaca() {
		return this.adresaProizvodjaca;
	}

	public void setAdresaProizvodjaca(String adresaProizvodjaca) {
		this.adresaProizvodjaca = adresaProizvodjaca;
	}

	public String getImeProizvodjaca() {
		return this.imeProizvodjaca;
	}

	public void setImeProizvodjaca(String imeProizvodjaca) {
		this.imeProizvodjaca = imeProizvodjaca;
	}

	public List<Proizvod> getProizvods() {
		return this.proizvods;
	}

	public void setProizvods(List<Proizvod> proizvods) {
		this.proizvods = proizvods;
	}

	public Proizvod addProizvod(Proizvod proizvod) {
		getProizvods().add(proizvod);
		proizvod.setProizvodjac(this);

		return proizvod;
	}

	public Proizvod removeProizvod(Proizvod proizvod) {
		getProizvods().remove(proizvod);
		proizvod.setProizvodjac(null);

		return proizvod;
	}

}