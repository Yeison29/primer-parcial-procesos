package com.primerparcialpn.articulos;

import com.primerparcialpn.articulos.models.Articulo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class ArticulosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticulosApplication.class, args);
	}
	//List<Articulo> findAllByCodigo(String codigo);
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
