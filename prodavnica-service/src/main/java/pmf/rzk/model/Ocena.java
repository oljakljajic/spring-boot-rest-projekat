package pmf.rzk.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the ocena database table.
 * 
 */
@Entity
@NamedQuery(name="Ocena.findAll", query="SELECT o FROM Ocena o")
public class Ocena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idocena;

	private String komentar;

	private int ocena;

	//bi-directional many-to-one association to Proizvod
	@ManyToOne
	@JoinColumn(name="proizvod_idproizvod")
	private Proizvod proizvod;

	public Ocena() {
	}

	public int getIdocena() {
		return this.idocena;
	}

	public void setIdocena(int idocena) {
		this.idocena = idocena;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Proizvod getProizvod() {
		return this.proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

}