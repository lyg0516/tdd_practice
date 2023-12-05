package sample.caffekiosk.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CaffekioskApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaffekioskApplication.class, args);
    }

}
