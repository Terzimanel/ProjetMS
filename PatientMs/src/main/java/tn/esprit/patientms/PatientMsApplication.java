package tn.esprit.patientms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PatientMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientMsApplication.class, args);
	}

}
