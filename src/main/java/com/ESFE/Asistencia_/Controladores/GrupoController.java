package com.ESFE.Asistencia_.Controladores;


import com.ESFE.Asistencia_.Entidades.Grupos;
import com.ESFE.Asistencia_.Repositorios.IGrupoRepository;
import com.ESFE.Asistencia_.Servicios.Inerfaces.IGruposServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.ESFE.Asistencia_.Entidades.Grupos;

import javax.naming.Binding;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/Grupos")

public class GrupoController {

    @Autowired
    private IGruposServices gruposServices;


    @GetMapping
    public String index(Model model, @RequestParam("page")Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) -1;
        int pageSize = size.orElse(10);
        Pageable pageable = PageRequest.of(currentPage,pageSize);
        Page<Grupos> grupos = gruposServices.BuscarTodosPaginados(pageable);
        model.addAttribute("grupos", grupos);
        int totalPage = grupos.getTotalPages();
        if(totalPage > 0){
            List<Integer> pageNumber = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());

            model.addAttribute("pageNumber");
        }
        return "grupo/index";
    }


    @GetMapping("/create")
    public String create(Grupos grupos){
        return "grupo/create";
    }

    @PostMapping("/save")
    public String save(Grupos grupos, BindingResult result, Model model, RedirectAttributes attributes){
        if (result.hasErrors()) {
            model.addAttribute(grupos);
            attributes.addFlashAttribute("error","no se pudo guardar debido a un error");
            return "grupo/create";
        }
        gruposServices.CrearOeditar(grupos);
        attributes.addFlashAttribute("msg","grupo creado correctamente");
        return "redirect:/grupos";


    }
}




