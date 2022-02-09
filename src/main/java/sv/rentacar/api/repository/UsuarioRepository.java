package sv.rentacar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.rentacar.api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String username);
}
