package com.ESFE.Asistencia_.Servicios.Inerfaces;

import com.ESFE.Asistencia_.Entidades.Docentes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IDocentesServices {
    Page<Docentes> BuscarTodosDocentesPaginados(Pageable pageable);
    List<Docentes> ObtenerDocentesTodos();
    Optional<Docentes> BuscarDocentesPorId(Integer id);
    Docentes CrearDocentesOeditar (Docentes grupos);
    void EliminarDocentesPorId(Integer id);
}
