package sv.rentacar.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sv.rentacar.api.dto.CitaDto;

import java.util.List;

@Controller
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;
    private static String urlApiRemote = "https://api.quotable.io/random";

    @GetMapping("/cita")
    public String getCitaLibro(Model model){
        CitaDto cita = restTemplate.getForObject(urlApiRemote,CitaDto.class);
        model.addAttribute("cita",cita);
        return "cita";
    }
}
