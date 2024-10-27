package pe.edu.upeu.boticasysfx.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "upeu_carrito_venta_detalle")
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long idDetalle;

    @NotNull(message = "El carrito no puede estar vacío")
    @ManyToOne
    @JoinColumn(name = "id_carrito", referencedColumnName = "id_carrito", nullable = false, foreignKey = @ForeignKey(name = "FK_CARRITO_DETALLE"))
    private CarritoVenta carritoVenta;

    @NotNull(message = "El medicamento no puede estar vacío")
    @ManyToOne
    @JoinColumn(name = "id_medicamento", referencedColumnName = "id_medicamento", nullable = false, foreignKey = @ForeignKey(name = "FK_MEDICAMENTO_DETALLE"))
    private Medicamento medicamento;

    @NotNull(message = "La cantidad no puede estar vacía")
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @NotNull(message = "El precio unitario no puede estar vacío")
    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;

    @NotNull(message = "El subtotal no puede estar vacío")
    @Column(name = "subtotal", nullable = false)
    private Double subtotal;
}
