package com.ESFE.Asistencia_.Servicios.Inerfaces;

import com.ESFE.Asistencia_.Entidades.Grupos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IGruposServices {
    Page<Grupos>  BuscarTodosPaginados(Pageable pageable);
    List<Grupos> ObtenerTodos();
    Optional<Grupos> BuscarPorId(Integer id);
    Grupos CrearOeditar (Grupos grupos);
    void EliminarPorId(Integer id);
}
