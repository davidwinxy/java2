package com.ESFE.Asistencia_.Controladores;


import com.ESFE.Asistencia_.Entidades.DocenteGrupo;
import com.ESFE.Asistencia_.Entidades.EstudianteGrupo;
import com.ESFE.Asistencia_.Entidades.Estudiantes;
import com.ESFE.Asistencia_.Servicios.Implementaciones.EstudianteGrupoServices;
import com.ESFE.Asistencia_.Servicios.Implementaciones.EstudianteServices;
import com.ESFE.Asistencia_.Servicios.Implementaciones.GrupoServices;
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
@RequestMapping("/EstudianteGrupos")
public class EstudianteGrupoController {


    @Autowired
    private EstudianteGrupoServices estudianteGrupoServices;

    @Autowired
    private EstudianteServices estudianteServices;

    @Autowired
    private GrupoServices grupoServices;


    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<EstudianteGrupo> estudianteGrupos = estudianteGrupoServices.BuscarTodosPaginados(pageable);
        model.addAttribute("estudianteGrupo", estudianteGrupos);
        int totalPage = estudianteGrupos.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "estudianteGrupo/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("estudianteGrupo", new EstudianteGrupo());
        model.addAttribute("estudiantes", estudianteServices.ObtenerTodos());
        model.addAttribute("grupos", grupoServices.ObtenerTodos());
        return "estudianteGrupo/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute EstudianteGrupo estudianteGrupo, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("estudianteGrupo", estudianteGrupo);
            model.addAttribute("estudiante", estudianteServices.ObtenerTodos());
            model.addAttribute("grupos", grupoServices.ObtenerTodos());
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error");
            return "estudianteGrupo/create";
        }
        estudianteGrupoServices.CrearOeditar(estudianteGrupo);
        attributes.addFlashAttribute("confirmar", "DocenteGrupo creado correctamente");
        return "redirect:/EstudianteGrupos";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        EstudianteGrupo estudianteGrupo = estudianteGrupoServices.BuscarPorId(id).orElse(null);
        if (estudianteGrupo == null) {
            return "redirect:/EstudianteGrupos";
        }
        model.addAttribute("estudianteGrupo", estudianteGrupo);
        return "estudianteGrupo/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        EstudianteGrupo estudianteGrupo = estudianteGrupoServices.BuscarPorId(id).orElse(null);
        if (estudianteGrupo == null) {
            return "redirect:/EstudianteGrupos";
        }
        model.addAttribute("estudianteGrupos", estudianteGrupo);
        model.addAttribute("estudiante", estudianteServices.ObtenerTodos());
        model.addAttribute("grupos", grupoServices.ObtenerTodos());
        return "estudianteGrupo/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        EstudianteGrupo estudianteGrupo = estudianteGrupoServices.BuscarPorId(id).orElse(null);
        if (estudianteGrupo == null) {
            return "redirect:/EstudianteGrupos";
        }
        model.addAttribute("estudianteGrupo", estudianteGrupo);
        return "estudianteGrupo/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute EstudianteGrupo estudianteGrupo, RedirectAttributes attributes) {
        estudianteGrupoServices.EliminarPorId(estudianteGrupo.getId());
        attributes.addFlashAttribute("msg", "DocenteGrupo eliminado correctamente");
        return "redirect:/EstudianteGrupos";
    }

}
