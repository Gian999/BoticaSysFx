package pe.edu.upeu.boticasysfx.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "upeu_carrito_venta")
public class CarritoVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private Long idCarrito;

    @NotNull(message = "El cliente no puede estar vacío")
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente",
            nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENTE_CARRITO"))
    private Cliente cliente;

    @OneToMany(mappedBy = "carritoVenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VentaDetalle> detalles;

    @NotNull(message = "El total no puede estar vacío")
    @Column(name = "total", nullable = false)
    private Double total;
}
