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
@Table(name = "upeu_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @NotNull(message = "El nombre de usuario no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre de usuario debe tener entre 3 y 50 caracteres")
    @Column(name = "user", nullable = false, unique = true, length = 50)
    private String user;

    @NotNull(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Column(name = "clave", nullable = false)
    private String clave;

    @NotNull(message = "El rol no puede estar vacío")
    @Column(name = "rol", nullable = false, length = 20)
    private String rol;

    @NotNull(message = "El rol no puede estar vacío")
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    @NotNull(message = "El nombre completo no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre completo debe tener entre 3 y 100 caracteres")
    @Column(name = "id_perfil", nullable = false, length = 100)
    private String id_perfil;

}
