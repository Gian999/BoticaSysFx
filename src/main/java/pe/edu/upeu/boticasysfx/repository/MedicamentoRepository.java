package pe.edu.upeu.boticasysfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.boticasysfx.model.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}
