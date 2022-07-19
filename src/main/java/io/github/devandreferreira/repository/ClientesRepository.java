package io.github.devandreferreira.repository;

import io.github.devandreferreira.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {


}
