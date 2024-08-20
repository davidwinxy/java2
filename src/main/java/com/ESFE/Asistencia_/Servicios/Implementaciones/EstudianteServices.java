package com.ESFE.Asistencia_.Servicios.Implementaciones;

import com.ESFE.Asistencia_.Entidades.Docentes;
import com.ESFE.Asistencia_.Entidades.Estudiantes;
import com.ESFE.Asistencia_.Entidades.Grupos;
import com.ESFE.Asistencia_.Repositorios.IEstudianteRepository;
import com.ESFE.Asistencia_.Servicios.Inerfaces.IEstudianteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EstudianteServices implements IEstudianteServices {

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Override
    public Page<Estudiantes> BuscarTodosPaginados(Pageable pageable) {
        return estudianteRepository.findAll(pageable);
    }

    @Override
    public List<Estudiantes> ObtenerTodos() {
        return estudianteRepository.findAll();
    }

    @Override
    public Optional<Estudiantes> BuscarPorId(Integer id) {
        return estudianteRepository.findById(id);

    }

    @Override
    public Estudiantes CrearOeditar(Estudiantes estudiantes) {
        return estudianteRepository.save(estudiantes);

    }

    @Override
    public void EliminarPorId(Integer id) {
        estudianteRepository.deleteById(id);
    }
}
