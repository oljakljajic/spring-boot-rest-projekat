package pmf.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the uloga database table.
 * 
 */
@Entity
@NamedQuery(name="Uloga.findAll", query="SELECT u FROM Uloga u")
public class Uloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduloga;

	private String nazivUloge;

	//bi-directional many-to-one association to Korisnikauloga
	@OneToMany(mappedBy="uloga")
	private List<Korisnikauloga> korisnikaulogas;

	public Uloga() {
	}

	public int getIduloga() {
		return this.iduloga;
	}

	public void setIduloga(int iduloga) {
		this.iduloga = iduloga;
	}

	public String getNazivUloge() {
		return this.nazivUloge;
	}

	public void setNazivUloge(String nazivUloge) {
		this.nazivUloge = nazivUloge;
	}

	public List<Korisnikauloga> getKorisnikaulogas() {
		return this.korisnikaulogas;
	}

	public void setKorisnikaulogas(List<Korisnikauloga> korisnikaulogas) {
		this.korisnikaulogas = korisnikaulogas;
	}

	public Korisnikauloga addKorisnikauloga(Korisnikauloga korisnikauloga) {
		getKorisnikaulogas().add(korisnikauloga);
		korisnikauloga.setUloga(this);

		return korisnikauloga;
	}

	public Korisnikauloga removeKorisnikauloga(Korisnikauloga korisnikauloga) {
		getKorisnikaulogas().remove(korisnikauloga);
		korisnikauloga.setUloga(null);

		return korisnikauloga;
	}

}