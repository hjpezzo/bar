package br.com.harley.bar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ATENÇÃO!!!! Pedido já consta como Preparado!!")
public class OrderAlreadyDoneException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderAlreadyDoneException() {
		super();
	}

	public OrderAlreadyDoneException(String message) {
		super(message);
	}

}
