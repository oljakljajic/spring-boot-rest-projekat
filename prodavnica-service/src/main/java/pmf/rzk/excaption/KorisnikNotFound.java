package pmf.rzk.excaption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class KorisnikNotFound extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	private int idKorisnika;
	
	public KorisnikNotFound(String msg, int idKorisnika) {
		super(msg);
		this.idKorisnika = idKorisnika;
	}

	public int getIdKorisnika() {
		return idKorisnika;
	}

	public void setIdKorisnika(int idKorisnika) {
		this.idKorisnika = idKorisnika;
	}
	
	

}
