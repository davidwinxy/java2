package com.ESFE.Asistencia_.Servicios.Inerfaces;

import com.ESFE.Asistencia_.Entidades.Estudiantes;
import com.ESFE.Asistencia_.Entidades.Grupos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEstudianteServices {
    Page<Estudiantes> BuscarTodosPaginados(Pageable pageable);
    List<Estudiantes> ObtenerTodos();
    Optional<Estudiantes> BuscarPorId(Integer id);
    Estudiantes CrearOeditar (Estudiantes estudiantes);
    void EliminarPorId(Integer id);
}
