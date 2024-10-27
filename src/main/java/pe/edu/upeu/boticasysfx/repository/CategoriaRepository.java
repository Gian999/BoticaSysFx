package pe.edu.upeu.boticasysfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.boticasysfx.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
