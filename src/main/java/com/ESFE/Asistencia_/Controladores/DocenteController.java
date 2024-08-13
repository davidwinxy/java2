package com.ESFE.Asistencia_.Controladores;


import com.ESFE.Asistencia_.Entidades.Docentes;
import com.ESFE.Asistencia_.Servicios.Inerfaces.IDocentesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

    @Autowired
    private IDocentesServices docenteServices;
    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<Docentes> docentes = docenteServices.BuscarTodosDocentesPaginados(pageable);
        model.addAttribute("docentes", docentes);
        int totalPage = docentes.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "docente/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("docentes", new Docentes());
        return "docente/create";
    }

    @PostMapping("/save")
    public String save(Docentes docentes, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("docentes", docentes);
            attributes.addFlashAttribute("error", "no se pudo guardar debido a un error");
            return "docente/create";
        }
        docenteServices.CrearDocentesOeditar(docentes);
        attributes.addFlashAttribute("confirmar", "docente creado correctamente");
        return "redirect:/docentes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        Docentes docentes = docenteServices.BuscarDocentesPorId(id).get();
        model.addAttribute("docentes", docentes);
        return "docente/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Docentes docentes = docenteServices.BuscarDocentesPorId(id).get();
        model.addAttribute("docentes", docentes);
        return "docente/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        Docentes docentes = docenteServices.BuscarDocentesPorId(id).get();
        model.addAttribute("docentes", docentes);
        return "docente/delete";
    }

    @PostMapping("/delete")
    public String delete(Docentes docentes, RedirectAttributes attributes){
        docenteServices.EliminarDocentesPorId(docentes.getId());
        attributes.addFlashAttribute("msg", "Docente eliminado correctamente");
        return "redirect:/docentes";
    }
}


