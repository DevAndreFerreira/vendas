package io.github.devandreferreira;

import io.github.devandreferreira.domain.entity.Cliente;
import io.github.devandreferreira.domain.entity.Pedido;
import io.github.devandreferreira.repository.ClientesRepository;
import io.github.devandreferreira.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;


@SpringBootApplication
@RestController
public class VendasApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired ClientesRepository clienteRepository, @Autowired PedidosRepository pedidosRepository) {
		return args -> {
			Cliente bruna = new Cliente("Bruna");
			clienteRepository.save(bruna);

			Pedido p = new Pedido();
			p.setCliente(bruna);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));
			p.setItens(new ArrayList<>());

			pedidosRepository.save(p);

			Cliente cliente = clienteRepository.findClienteFetchPedidos(bruna.getId());
			System.out.println(cliente);
			System.out.println(cliente.getPedidos());
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
