package py.com.nurseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class NurseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NurseAppApplication.class, args);
	}	
	
	@RequestMapping("patiens")
    public String createPatient() {
       
        return "Hola";
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{id-patient}")
//                .buildAndExpand(patientRegister.getCodPatient()).toUri();
//        return ResponseEntity.created(location).build();

    }
}
