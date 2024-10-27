package pe.edu.upeu.boticasysfx.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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

    @Column(name = "precio_base", nullable = false)
    private Double precioBase;

    @Column(name = "igv", nullable = false)
    private Double igv;

    @Positive(message = "El total debe ser positivo")
    @Column(name = "precio_Total", nullable = false)
    private Double precioTotal;

    @NotNull(message = "El medicamento no puede estar vacío")
    @ManyToOne
    @JoinColumn(name = "id_medicamento", referencedColumnName = "id_medicamento",
            nullable = false, foreignKey = @ForeignKey(name = "FK_MEDICAMENTO_VENTA"))
    private Medicamento medicamento;



    @ManyToOne
    @JoinColumn(name = "dniruc", referencedColumnName = "dniruc",
            nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENTE_VENTA"))
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario",
            nullable = false, foreignKey = @ForeignKey(name = "FK_USUARIO_VENTA"))
    private Usuario usuario;
    @Column(name = "num_doc", nullable = false, length = 20)
    private String numDoc;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_gener", nullable = false)
    private LocalDateTime fechaGener;
    @Column(name = "serie", nullable = false, length = 20)
    private String serie;
    @Column(name = "tipo_doc", nullable = false, length = 10)
    private String tipoDoc;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VentaDetalle> ventaDetalles;



}

