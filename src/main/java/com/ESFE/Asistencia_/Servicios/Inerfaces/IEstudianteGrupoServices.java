package com.ESFE.Asistencia_.Servicios.Inerfaces;

import com.ESFE.Asistencia_.Entidades.DocenteGrupo;
import com.ESFE.Asistencia_.Entidades.EstudianteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEstudianteGrupoServices {
    Page<EstudianteGrupo> BuscarTodosPaginados(Pageable pageable);
    List<EstudianteGrupo> ObtenerTodos();
    Optional<EstudianteGrupo> BuscarPorId(Integer id);
    EstudianteGrupo CrearOeditar (EstudianteGrupo estudianteGrupo);
    void EliminarPorId(Integer id);
}
