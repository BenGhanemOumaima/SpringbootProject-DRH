package tn.formalab.DRH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DrhApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrhApplication.class, args);
	}

}
