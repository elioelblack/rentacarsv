package sv.rentacar.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sv.rentacar.api.entity.Usuario;
import sv.rentacar.api.repository.UsuarioRepository;

import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private Collection<? extends GrantedAuthority> authorities;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return new RentacarsvUserDetails(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.getIdRol().getNombre());
    }
}
