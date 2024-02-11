package pmf.rzk.excaption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExcaptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(KorisnikNotFound.class)
	public ResponseEntity<ErrorDetails> handleKorisnikNotFound(KorisnikNotFound ex, WebRequest request) {
		ErrorDetails er = new ErrorDetails(ex.getMessage(), ex.getIdKorisnika());
		return new ResponseEntity<ErrorDetails>(er, HttpStatus.NOT_FOUND);
	}
}
