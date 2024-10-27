package pe.edu.upeu.boticasysfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upeu.boticasysfx.model.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    @Query(value = "SELECT * FROM upeu_cliente WHERE nombrers like :nombre", nativeQuery = true)
    List<Cliente> findByNombre(@Param(value = "nombre") String nombre);
    @Query(value = "SELECT c.* FROM upeu_cliente c WHERE c.nombrers like :filter", nativeQuery = true)
    List<Cliente> listAutoCompletCliente(@Param("filter") String filter);
}
