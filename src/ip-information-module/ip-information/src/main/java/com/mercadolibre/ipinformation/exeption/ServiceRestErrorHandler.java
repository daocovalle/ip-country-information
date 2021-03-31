
package com.mercadolibre.ipinformation.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mercadolibre.ipinformation.dto.response.ErrorResponseDTO;

import io.netty.handler.timeout.TimeoutException;

@ControllerAdvice(annotations = RestController.class)
public class ServiceRestErrorHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ErrorResponseDTO> serviceError(ServiceException serviceException) {
		ErrorResponseDTO error = new ErrorResponseDTO(serviceException.getErrorMessage(),
				serviceException.getErrorCode());
		return ResponseEntity.ok().body(error);
	}

	@ExceptionHandler(WebClientResponseException.class)
	public ResponseEntity<ErrorResponseDTO> serviceError(WebClientResponseException exception) {
		ErrorResponseDTO error = new ErrorResponseDTO(exception.getLocalizedMessage(), exception.getRawStatusCode());
		return ResponseEntity.ok().body(error);
	}

	@ExceptionHandler(TimeoutException.class)
	public ResponseEntity<ErrorResponseDTO> serviceError(TimeoutException exception) {
		ErrorResponseDTO error = new ErrorResponseDTO(exception.getLocalizedMessage(),
				HttpStatus.REQUEST_TIMEOUT.value());
		return ResponseEntity.ok().body(error);
	}

	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<ErrorResponseDTO> serviceError(InternalServerError exception) {
		ErrorResponseDTO error = new ErrorResponseDTO(exception.getLocalizedMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.ok().body(error);
	}

}
