package py.com.naturabeans.nurseappapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("py.com")
@SpringBootApplication
public class NurseappApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NurseappApiApplication.class, args);
    }
}
