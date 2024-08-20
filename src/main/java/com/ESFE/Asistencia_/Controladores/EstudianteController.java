package com.ESFE.Asistencia_.Controladores;

import com.ESFE.Asistencia_.Entidades.Estudiantes;
import com.ESFE.Asistencia_.Entidades.Grupos;
import com.ESFE.Asistencia_.Servicios.Inerfaces.IEstudianteServices;
import com.ESFE.Asistencia_.Servicios.Inerfaces.IGruposServices;
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
@RequestMapping("/Estudiantes")
public class EstudianteController {


    @Autowired
    private IEstudianteServices estudianteServices;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<Estudiantes> estudiantes = estudianteServices.BuscarTodosPaginados(pageable);
        model.addAttribute("estudiante", estudiantes);
        int totalPage = estudiantes.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "estudiante/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("estudiante", new Estudiantes());
        return "estudiante/create";
    }

    @PostMapping("/save")
    public String save(Estudiantes estudiantes, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("estudiante", estudiantes);
            attributes.addFlashAttribute("error", "no se pudo guardar debido a un error");
            return "estudiante/create";
        }
        estudianteServices.CrearOeditar(estudiantes);
        attributes.addFlashAttribute("confirmar", "grupo creado correctamente");
        return "redirect:/Estudiantes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        Estudiantes estudiantes = estudianteServices.BuscarPorId(id).get();
        model.addAttribute("estudiante", estudiantes);
        return "estudiante/details";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Estudiantes estudiantes = estudianteServices.BuscarPorId(id).get();
        model.addAttribute("estudiante", estudiantes);
        return "estudiante/edit";
    }


    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        Estudiantes estudiantes = estudianteServices.BuscarPorId(id).get();
        model.addAttribute("estudiante", estudiantes);
        return "estudiante/delete";
    }

    @PostMapping("/delete")
    public String delete(Estudiantes estudiantes, RedirectAttributes attributes){
        estudianteServices.EliminarPorId(estudiantes.getId());
        attributes.addFlashAttribute("msg", "estudiante eliminado correctamente");
        return "redirect:/Estudiantes";
    }
}

