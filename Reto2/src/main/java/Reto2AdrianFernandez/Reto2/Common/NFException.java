package Reto2AdrianFernandez.Reto2.Common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No se ha encontrado ergo no existe")
public class NFException extends RuntimeException{
    private static final long serialVersionUID = 1L;
}
