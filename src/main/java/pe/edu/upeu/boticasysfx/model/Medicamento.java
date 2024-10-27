package pe.edu.upeu.boticasysfx.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "upeu_medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicamento")
    private Long idMedicamento;

    @NotNull(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 120, message = "El nombre debe tener entre 2 y 120 caracteres")
    @Column(name = "nombre", nullable = false, length = 120)
    private String nombre;

    @Positive(message = "El precio debe ser positivo")
    @Column(name = "precio", nullable = false)
    private Double precio;

    @Positive(message = "La cantidad en stock debe ser positiva")
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @NotNull(message = "La categoría no puede estar vacía")
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria",
            nullable = false, foreignKey = @ForeignKey(name = "FK_CATEGORIA_MEDICAMENTO"))
    private Categoria categoria;

    @NotNull(message = "La marca no puede estar vacía")
    @ManyToOne
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca",
            nullable = false, foreignKey = @ForeignKey(name = "FK_MARCA_MEDICAMENTO"))
    private Marca marca;
}
