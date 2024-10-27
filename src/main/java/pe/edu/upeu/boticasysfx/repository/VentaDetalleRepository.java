package pe.edu.upeu.boticasysfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upeu.boticasysfx.model.CarritoVenta;
import pe.edu.upeu.boticasysfx.model.VentaDetalle;

import java.util.List;

public interface VentaDetalleRepository extends JpaRepository<VentaDetalle, Long> {
    @Query(value = "SELECT c.* FROM upeu_vent_carrito c WHERE c.dniruc=:dniruc", nativeQuery = true)
    List<CarritoVenta> listaCarritoCliente(@Param("dniruc") String dniruc);
    void deleteByDniruc(/*@Param("dniruc")*/ String dniruc);
}
