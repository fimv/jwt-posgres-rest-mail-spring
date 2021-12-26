package net.proselyte.jwtappdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"net.proselyte.jwtappdemo", "net.proselyte.jwtappdemo.config", "net.proselyte.jwtappdemo.dto",
	"net.proselyte.jwtappdemo.model", "net.proselyte.jwtappdemo.repository", "net.proselyte.jwtappdemo.rest", 
	"net.proselyte.jwtappdemo.security", "net.proselyte.jwtappdemo.security.jwt", "net.proselyte.jwtappdemo.service",
	"net.proselyte.jwtappdemo.service.impl"})
public class JwtAppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtAppDemoApplication.class, args);
	}

}
