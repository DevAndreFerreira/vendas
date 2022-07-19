package io.github.devandreferreira.repository;

import io.github.devandreferreira.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidosRepository extends JpaRepository<Pedido, Integer> {

}
