package com.ESFE.Asistencia_.Servicios.Implementaciones;

import com.ESFE.Asistencia_.Entidades.DocenteGrupo;
import com.ESFE.Asistencia_.Entidades.EstudianteGrupo;
import com.ESFE.Asistencia_.Entidades.Estudiantes;
import com.ESFE.Asistencia_.Repositorios.IDocenteGrupoRepository;
import com.ESFE.Asistencia_.Repositorios.IEstudianteGrupoRepository;
import com.ESFE.Asistencia_.Repositorios.IEstudianteRepository;
import com.ESFE.Asistencia_.Servicios.Inerfaces.IEstudianteGrupoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EstudianteGrupoServices implements IEstudianteGrupoServices {

    @Autowired
    private IEstudianteGrupoRepository estudianteGrupoRepository;


    public Page<EstudianteGrupo> BuscarTodosPaginados(Pageable pageable){
        return estudianteGrupoRepository.findByOrderByEstudianteDesc(pageable);
    }

    @Override
    public List<EstudianteGrupo> ObtenerTodos() {
        return estudianteGrupoRepository.findAll();
    }

    @Override
    public Optional<EstudianteGrupo> BuscarPorId(Integer id) {
        return estudianteGrupoRepository.findById(id);
    }

    @Override
    public EstudianteGrupo CrearOeditar(EstudianteGrupo estudianteGrupo) {
        return estudianteGrupoRepository.save(estudianteGrupo);
    }

    @Override
    public void EliminarPorId(Integer id) {
        estudianteGrupoRepository.deleteById(id);
    }
}
