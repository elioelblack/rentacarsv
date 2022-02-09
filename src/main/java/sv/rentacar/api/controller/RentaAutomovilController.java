package sv.rentacar.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sv.rentacar.api.entity.AuditRenta;
import sv.rentacar.api.entity.Automovil;
import sv.rentacar.api.entity.Usuario;
import sv.rentacar.api.service.api.AuditRentaServiceAPI;
import sv.rentacar.api.service.api.AutomovilServiceAPI;
import sv.rentacar.api.service.api.UsuarioServiceAPI;

@Controller
public class RentaAutomovilController {

    @Autowired
    private AutomovilServiceAPI automovilServiceAPI;
    @Autowired
    private UsuarioServiceAPI usuarioServiceAPI;
    @Autowired
    private AuditRentaServiceAPI auditRentaServiceAPI;

    @GetMapping("/rentar/{id}")
    public String rentar(@PathVariable(name = "id") Integer id, Model model){
        if(id!=null&&id!=0){
            Automovil automovil = automovilServiceAPI.findById(id);
            if(automovil==null){
                return "rentar?error";
            }
            model.addAttribute("auto",automovil);
            AuditRenta auditRenta = new AuditRenta();
            model.addAttribute("audit",auditRenta);
        }
        return "rentar";
    }

    @PostMapping("/save/audit/{id}")
    public String save(@PathVariable(name = "id") Integer id, Model model, Authentication auth){
        Usuario usuario = usuarioServiceAPI.findByUsername(auth.getName());
        Automovil automovil = automovilServiceAPI.findById(id);
        AuditRenta auditRenta = new AuditRenta();
        auditRenta.setIdUsuario(usuario);
        automovil.setDisponible(false);
        auditRenta.setIdAutomovil(automovil);
        auditRentaServiceAPI.save(auditRenta);
        return "redirect:/index?exito";
    }

}
