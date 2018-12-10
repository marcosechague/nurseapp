package py.com.nurseapp.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ControllerDemo {

	 private static final Logger LOGGER= LoggerFactory.getLogger(ControllerDemo.class);

	
	@RequestMapping("hello")
	public String getHello(){
		return "Hello";
	}
	
	 @GetMapping("patient")
	    public ResponseEntity<String> createPatient( ) {
	        LOGGER.info("IN POST /patients {}", "asd");
	        String patientRegister =  "1";//patientService.createPatient(patientDto);
	         
	        LOGGER.info("OUT POST /patients {} ",patientRegister);
	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest().path("/{id-patient}")
	                .buildAndExpand(patientRegister).toUri();
	        return ResponseEntity.created(location).build();

	    }
}
