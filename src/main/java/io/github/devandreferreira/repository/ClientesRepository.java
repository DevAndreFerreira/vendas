package io.github.devandreferreira.repository;

import io.github.devandreferreira.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    List<Object> findByNomeLike(String cli);

    List<Cliente> findByNomeOrIdOrderById(String nome, String id);

    Cliente findOneByNome(String nome);

    boolean existsByNome(String nome);

}
