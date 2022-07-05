package io.github.devandreferreira;

import io.github.devandreferreira.domain.entity.Cliente;
import io.github.devandreferreira.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClientesRepository cliente) {
		return args -> {

			System.out.println("Salvando clientes");
			cliente.save(new Cliente("Bruna"));
			cliente.save(new Cliente("André"));

			boolean existe = cliente.existsByNome("André");
			System.out.println("Existe? " + existe);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
