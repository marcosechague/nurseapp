package py.com.nurseapp.exception;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import py.com.nurseapp.exception.ErrorResponse;

@ControllerAdvice
public class NurseAppExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(NurseAppExceptionHandler.class);
	
	private static final String ERROR_INVALID_BODY_REQUEST = "errbr1000";
	private static final String ERROR_INVALID_PARAMETER = "errp1000";
	private static final String ERROR_INVALID_METHOD = "errm1000";
	private static final String ERROR_DATABASE = "errdb1000";
	private static final String ERROR_UNEXPECTED= "errnn1000";
	
	@ExceptionHandler(value = Throwable.class)
	public @ResponseBody ErrorResponse handleGlobalException(HttpServletRequest request, HttpServletResponse response, Throwable e)
	{
		logger.error("Error to manage ", e);
		request.setAttribute("ApiException", e);
		ErrorResponse eb = new ErrorResponse();
		
		boolean statusSet = false;
		
		 if (e instanceof MissingServletRequestParameterException) {
			MissingServletRequestParameterException msrpe = (MissingServletRequestParameterException)e;
			eb.setCode(ERROR_INVALID_PARAMETER);
			eb.setMessage(String.format("Parameter [%s] type [%s] is missing", msrpe.getParameterName(), msrpe.getParameterType()));
			
		}else if(e instanceof HttpMessageNotReadableException){
			eb.setCode(ERROR_INVALID_BODY_REQUEST);
			eb.setMessage("Parametro del body invalido o inexistente");
		} else if (e instanceof MethodArgumentNotValidException){
			MethodArgumentNotValidException manve = (MethodArgumentNotValidException)e;
			eb.setCode(ERROR_INVALID_BODY_REQUEST);
			eb.setMessage(String.format("Parameter [%s] type [%s] is needed in the body", manve.getParameter().getParameterName(), manve.getParameter().getParameterType()));
		} else if (e instanceof HttpRequestMethodNotSupportedException) {
			HttpRequestMethodNotSupportedException mnse = (HttpRequestMethodNotSupportedException)e;
			eb.setCode(ERROR_INVALID_METHOD);
			eb.setMessage(mnse.getMessage());
			response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			statusSet = true;
			eb.setCode(ERROR_DATABASE);
			eb.setMessage("Error DATABASE inesperado");
		} else if (e instanceof SQLException) {
			eb.setCode(ERROR_DATABASE);
			eb.setMessage("Error DATABASE inesperado");
		} else {
			eb.setCode(ERROR_UNEXPECTED);
			eb.setMessage("Unexpected server exception");
		}
		
		 eb.setTime(new Date());
		 
		if (!statusSet) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
		}
		
		return eb;
	}
	
}
