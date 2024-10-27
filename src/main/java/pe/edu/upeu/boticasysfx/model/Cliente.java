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
@Table(name = "upeu_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private String dniruc;

    @NotNull(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 120, message = "El nombre debe tener entre 2 y 120 caracteres")
    @Column(name = "nombres", nullable = false, length = 120)
    private String nombres;

    @Size(max = 15, message = "El número de teléfono debe tener máximo 15 caracteres")
    @Column(name = "rep_legal", length = 15)
    private String repLegal;

    @Size(max = 100, message = "La dirección debe tener máximo 100 caracteres")
    @Column(name = "tipo_documento", length = 100)
    private String tipoDocumento;

}
