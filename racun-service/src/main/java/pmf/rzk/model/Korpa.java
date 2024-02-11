package pmf.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the korpa database table.
 * 
 */
@Entity
@NamedQuery(name="Korpa.findAll", query="SELECT k FROM Korpa k")
public class Korpa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkorpa;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datumNarudzbine;

	//bi-directional many-to-one association to Proizvodkorpa
	@JsonIgnore
	@OneToMany(mappedBy="korpa")
	private List<Proizvodkorpa> proizvodkorpas;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="korisnika_idkorisnika")
	private Korisnik korisnik;

	public Korpa() {
	}

	public int getIdkorpa() {
		return this.idkorpa;
	}

	public void setIdkorpa(int idkorpa) {
		this.idkorpa = idkorpa;
	}

	public Date getDatumNarudzbine() {
		return this.datumNarudzbine;
	}

	public void setDatumNarudzbine(Date datumNarudzbine) {
		this.datumNarudzbine = datumNarudzbine;
	}

	public List<Proizvodkorpa> getProizvodkorpas() {
		return this.proizvodkorpas;
	}

	public void setProizvodkorpas(List<Proizvodkorpa> proizvodkorpas) {
		this.proizvodkorpas = proizvodkorpas;
	}

	public Proizvodkorpa addProizvodkorpa(Proizvodkorpa proizvodkorpa) {
		getProizvodkorpas().add(proizvodkorpa);
		proizvodkorpa.setKorpa(this);

		return proizvodkorpa;
	}

	public Proizvodkorpa removeProizvodkorpa(Proizvodkorpa proizvodkorpa) {
		getProizvodkorpas().remove(proizvodkorpa);
		proizvodkorpa.setKorpa(null);

		return proizvodkorpa;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}