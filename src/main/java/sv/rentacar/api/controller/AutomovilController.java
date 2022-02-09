package sv.rentacar.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import sv.rentacar.api.dto.CitaDto;
import sv.rentacar.api.entity.Automovil;
import sv.rentacar.api.entity.Modelo;
import sv.rentacar.api.entity.Usuario;
import sv.rentacar.api.service.api.AutomovilServiceAPI;
import sv.rentacar.api.service.api.ModeloServiceAPI;
import sv.rentacar.api.service.api.UsuarioServiceAPI;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AutomovilController {

    @Autowired
    private AutomovilServiceAPI automovilServiceAPI;
    @Autowired
    private RestTemplate restTemplate;
    private static String urlApiRemote = "https://api.quotable.io/random";
    @Autowired
    private UsuarioServiceAPI usuarioServiceAPI;
    @Autowired
    private ModeloServiceAPI modeloServiceAPI;

    @GetMapping("/index")
    public String findAllActives(Authentication auth, HttpSession session,@RequestParam Map<String, Object> params, Model model){

        if(session.getAttribute("usuario")==null){
            Usuario usuario = null;
            if(auth!=null){
                String username = auth.getName();
                usuario = usuarioServiceAPI.findByUsername(username);
                usuario.setPassword(null);
            }
            session.setAttribute("usuario",usuario);
        }
        int page = params.get("page")!=null? (Integer.valueOf(params.get("page").toString())-1):0;

        //Sort
        Sort sort = Sort.by("nombre").ascending();
        if(params.get("sortField")!=null&&params.get("sortDir")!=null){
            String sortField = (String)params.get("sortField");
            String sortDirection = (String)params.get("sortDir");
            sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortField).ascending()
                    :Sort.by(sortField).descending();
            model.addAttribute("sortField", sortField);
            model.addAttribute("sortDir", sortDirection);
            model.addAttribute("reverseSortDir", sortDirection.equalsIgnoreCase("asc")?"desc":"asc");
        }else{
            model.addAttribute("reverseSortDir","desc");
        }
        PageRequest pageRequest = PageRequest.of(page,10, sort);


        Page<Automovil> pageAutomovil = automovilServiceAPI.getAllActives(pageRequest,true, true);
        int totalPage = pageAutomovil.getTotalPages();
        if(totalPage>0){
            List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages",pages);
        }
        CitaDto cita = restTemplate.getForObject(urlApiRemote,CitaDto.class);
        model.addAttribute("cita",cita);
        model.addAttribute("list",pageAutomovil.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next",page+2);
        model.addAttribute("prev",page);
        model.addAttribute("last",totalPage);

        return "index";
    }

    @GetMapping("/administrador")
    public String listar(@RequestParam Map<String, Object> params, Model model){
        int page = params.get("page")!=null? (Integer.valueOf(params.get("page").toString())-1):0;

        PageRequest pageRequest = PageRequest.of(page,10);
        Page<Automovil> pageAutomovil = automovilServiceAPI.getAll(pageRequest);
        int totalPage = pageAutomovil.getTotalPages();
        if(totalPage>0){
            List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages",pages);
        }
        CitaDto cita = restTemplate.getForObject(urlApiRemote,CitaDto.class);
        model.addAttribute("cita",cita);
        model.addAttribute("list",pageAutomovil.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next",page+2);
        model.addAttribute("prev",page);
        model.addAttribute("last",totalPage);

        return "listar";
    }

    @GetMapping("/agregar/{id}")
    public String agregar(@PathVariable(name = "id")Integer id, Model model, Authentication auth){
        if(id!=null&&id!=0){
            model.addAttribute("automovil",automovilServiceAPI.findById(id));
        }else{
            Automovil automovil = new Automovil();
            automovil.setLastUser(auth.getName());
            model.addAttribute("automovil",automovil);
        }

        List<Modelo> listaModelo = modeloServiceAPI.findAll();
        model.addAttribute("listaModelo", listaModelo);
        return "agregar";
    }

    @GetMapping("/agregar")
    public String agregar2(Model model, Authentication auth){

            Automovil automovil = new Automovil();
            automovil.setLastUser(auth.getName());
            model.addAttribute("automovil",automovil);


        List<Modelo> listaModelo = modeloServiceAPI.findAll();
        model.addAttribute("listaModelo", listaModelo);
        return "agregar";
    }


    @PostMapping("/save")
    public String save(Automovil automovil, Model model, Authentication auth){
        automovil.setLastUser(auth.getName());
        automovilServiceAPI.save(automovil);

        return "redirect:/administrador";
    }

    @GetMapping("/delete/{id}")
    public String test(@PathVariable(name = "id")Integer id, Model model){
        automovilServiceAPI.deleteById(id);
        return "redirect:/administrador";
    }



}
