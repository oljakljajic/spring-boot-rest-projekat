package pmf.rzk.excaption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProizvodNotFound  extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	private int idProizvod;
	
	public ProizvodNotFound(String msg, int idProizvod) {
		super(msg);
		this.idProizvod = idProizvod;
	}

	public int getIdProizvod() {
		return idProizvod;
	}

	public void setIdProizvod(int idProizvod) {
		this.idProizvod = idProizvod;
	}
	
	
	

}
