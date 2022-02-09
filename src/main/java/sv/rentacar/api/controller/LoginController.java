package sv.rentacar.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sv.rentacar.api.entity.Usuario;
import sv.rentacar.api.repository.UsuarioRepository;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("usuario",new Usuario());

        return "login";
    }

}
