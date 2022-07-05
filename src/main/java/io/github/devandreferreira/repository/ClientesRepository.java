package io.github.devandreferreira.repository;

import io.github.devandreferreira.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "select c from Cliente c where c.nome like :nome")
    Cliente encontraPorNome(@Param("nome") String nome);

    @Query(value = "delete from Cliente c where c.nome =:nome")
    @Modifying
    void deleteByNome(String nome);

    List<Object> findByNomeLike(String cli);

    List<Cliente> findByNomeOrIdOrderById(String nome, String id);

    Cliente findOneByNome(String nome);

    boolean existsByNome(String nome);

    @Query("select c from Cliente c left join fetch c.pedidos p where c.id = :id")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);




}
