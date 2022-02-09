package sv.rentacar.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sv.rentacar.api.entity.Automovil;
import sv.rentacar.api.service.api.AutomovilServiceAPI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AutomovilController {

    @Autowired
    private AutomovilServiceAPI automovilServiceAPI;

    @GetMapping("/")
    public String findAll(@RequestParam Map<String, Object> params, Model model){
        int page = params.get("page")!=null? (Integer.valueOf(params.get("page").toString())-1):0;

        PageRequest pageRequest = PageRequest.of(page,10);
        Page<Automovil> pageAutomovil = automovilServiceAPI.getAll(pageRequest);
        int totalPage = pageAutomovil.getTotalPages();
        if(totalPage>0){
            List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
        }

        model.addAttribute("list",pageAutomovil.getContent());

        return "index";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
