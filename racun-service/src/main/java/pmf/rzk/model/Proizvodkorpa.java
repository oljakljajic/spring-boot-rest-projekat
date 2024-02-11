package pmf.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;


/**
 * The persistent class for the proizvodkorpa database table.
 * 
 */
@Entity
@NamedQuery(name="Proizvodkorpa.findAll", query="SELECT p FROM Proizvodkorpa p")
public class Proizvodkorpa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproizvodkorpa;
	
	@Min(value = 1)
	private int kolicina;

	//bi-directional many-to-one association to Korpa
	@ManyToOne
	private Korpa korpa;

	//bi-directional many-to-one association to Proizvod
	@ManyToOne
	private Proizvod proizvod;

	public Proizvodkorpa() {
	}

	public int getIdproizvodkorpa() {
		return this.idproizvodkorpa;
	}

	public void setIdproizvodkorpa(int idproizvodkorpa) {
		this.idproizvodkorpa = idproizvodkorpa;
	}

	public int getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public Korpa getKorpa() {
		return this.korpa;
	}

	public void setKorpa(Korpa korpa) {
		this.korpa = korpa;
	}

	public Proizvod getProizvod() {
		return this.proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

}