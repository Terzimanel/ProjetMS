package tn.esprit.rendezvousms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RendezvousMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RendezvousMsApplication.class, args);
    }

}
