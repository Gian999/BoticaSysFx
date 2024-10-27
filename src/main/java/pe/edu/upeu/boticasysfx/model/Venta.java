package pe.edu.upeu.boticasysfx.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "upeu_venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;

    @NotNull(message = "La fecha de venta no puede estar vacía")
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Positive(message = "La cantidad vendida debe ser positiva")
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Positive(message = "El total debe ser positivo")
    @Column(name = "total", nullable = false)
    private Double total;

    @NotNull(message = "El medicamento no puede estar vacío")
    @ManyToOne
    @JoinColumn(name = "id_medicamento", referencedColumnName = "id_medicamento",
            nullable = false, foreignKey = @ForeignKey(name = "FK_MEDICAMENTO_VENTA"))
    private Medicamento medicamento;
}

