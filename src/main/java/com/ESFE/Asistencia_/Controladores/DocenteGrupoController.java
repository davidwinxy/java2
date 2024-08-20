package com.ESFE.Asistencia_.Controladores;

import com.ESFE.Asistencia_.Entidades.DocenteGrupo;

import com.ESFE.Asistencia_.Servicios.Implementaciones.DocenteGrupoServices;
import com.ESFE.Asistencia_.Servicios.Implementaciones.DocenteServices;
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
@RequestMapping("/DocenteGrupos")
public class    DocenteGrupoController {

    @Autowired
    private DocenteGrupoServices docenteGrupoServices;

    @Autowired
    private DocenteServices docenteServices;

    @Autowired
    private GrupoServices grupoService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<DocenteGrupo> docenteGrupos = docenteGrupoServices.BuscarTodosPaginados(pageable);
        model.addAttribute("docenteGrupos", docenteGrupos);
        int totalPage = docenteGrupos.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "docenteGrupo/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("docenteGrupo", new DocenteGrupo());
        model.addAttribute("docentes", docenteServices.ObtenerDocentesTodos());
        model.addAttribute("grupos", grupoService.ObtenerTodos());
        return "docenteGrupo/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute DocenteGrupo docenteGrupo, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("docenteGrupo", docenteGrupo);
            model.addAttribute("docentes", docenteServices.ObtenerDocentesTodos());
            model.addAttribute("grupos", grupoService.ObtenerTodos());
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error");
            return "docenteGrupo/create";
        }
        docenteGrupoServices.CrearOeditar(docenteGrupo);
        attributes.addFlashAttribute("confirmar", "DocenteGrupo creado correctamente");
        return "redirect:/DocenteGrupos";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        DocenteGrupo docenteGrupo = docenteGrupoServices.BuscarPorId(id).orElse(null);
        if (docenteGrupo == null) {
            return "redirect:/DocenteGrupos";
        }
        model.addAttribute("docenteGrupo", docenteGrupo);
        return "docenteGrupo/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        DocenteGrupo docenteGrupo = docenteGrupoServices.BuscarPorId(id).orElse(null);
        if (docenteGrupo == null) {
            return "redirect:/docenteGrupos";
        }
        model.addAttribute("docenteGrupo", docenteGrupo);
        model.addAttribute("docentes", docenteServices.ObtenerDocentesTodos());
        model.addAttribute("grupos", grupoService.ObtenerTodos());
        return "docenteGrupo/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        DocenteGrupo docenteGrupo = docenteGrupoServices.BuscarPorId(id).orElse(null);
        if (docenteGrupo == null) {
            return "redirect:/DocenteGrupos";
        }
        model.addAttribute("docenteGrupo", docenteGrupo);
        return "docenteGrupo/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute DocenteGrupo docenteGrupo, RedirectAttributes attributes) {
        docenteGrupoServices.EliminarPorId(docenteGrupo.getId());
        attributes.addFlashAttribute("msg", "DocenteGrupo eliminado correctamente");
        return "redirect:/DocenteGrupos";
    }
}



