package io.github.devandreferreira.controller;

import io.github.devandreferreira.domain.entity.Cliente;
import io.github.devandreferreira.dto.ClienteDto;
import io.github.devandreferreira.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class ClienteController {

    @Autowired
    private ClientesRepository clientesRepository;

    @GetMapping("clientes/{id}")
    public ResponseEntity<Object> getClienteById(@PathVariable Integer id) {
        Optional<Cliente> clienteOptional = clientesRepository.findById(id);
        if (clienteOptional.isPresent()) {
            return new ResponseEntity<>(clienteOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Object> saveCliente(@RequestBody ClienteDto clienteDto) {
        Cliente cliente = new Cliente(clienteDto.getNome());
        Cliente novoCliente = clientesRepository.save(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable Integer id) {
        if (clientesRepository.findById(id).isPresent()) {
            clientesRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<Object> atualizarClientePorId(@PathVariable Integer id, @RequestBody ClienteDto clienteDto) {
        Optional<Cliente> clientePorId = clientesRepository.findById(id);
        if (clientePorId.isPresent()) {
            Cliente cliente = clientePorId.get();
            cliente.setNome(clienteDto.getNome());
            clientesRepository.save(cliente);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
