package pe.edu.upeu.boticasysfx.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "upeu_proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long idProveedor;

    @NotNull(message = "El nombre del proveedor no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 15, message = "El teléfono no debe exceder los 15 caracteres")
    @Column(name = "telefono", length = 15)
    private String telefono;

    @Size(max = 100, message = "La dirección no debe exceder los 100 caracteres")
    @Column(name = "direccion", length = 100)
    private String direccion;
}
