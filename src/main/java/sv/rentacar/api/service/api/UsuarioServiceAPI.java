package sv.rentacar.api.service.api;

import sv.rentacar.api.entity.Usuario;

public interface UsuarioServiceAPI {
    Usuario findByUsername(String username);
}
