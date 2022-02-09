package sv.rentacar.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.rentacar.api.entity.Usuario;
import sv.rentacar.api.repository.UsuarioRepository;
import sv.rentacar.api.service.api.UsuarioServiceAPI;

@Service
public class UsuarioServiceImpl implements UsuarioServiceAPI {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
