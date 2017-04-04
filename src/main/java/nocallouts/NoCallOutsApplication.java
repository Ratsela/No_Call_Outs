package nocallouts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan
@ComponentScan(basePackages={"nocallouts.controllers.*"})
@Configuration
@EnableAutoConfiguration
public class NoCallOutsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoCallOutsApplication.class, args);
	}
}
