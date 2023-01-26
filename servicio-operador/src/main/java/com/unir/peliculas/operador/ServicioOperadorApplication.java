package com.unir.peliculas.operador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServicioOperadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioOperadorApplication.class, args);
	}

}
