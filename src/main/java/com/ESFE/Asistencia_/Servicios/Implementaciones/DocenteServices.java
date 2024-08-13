package com.ESFE.Asistencia_.Servicios.Implementaciones;

import com.ESFE.Asistencia_.Entidades.Docentes;
import com.ESFE.Asistencia_.Repositorios.IDocenteRepository;
import com.ESFE.Asistencia_.Servicios.Inerfaces.IDocentesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServices implements IDocentesServices {

    @Autowired
    private IDocenteRepository docenteRepository;

    @Override
    public Page<Docentes> BuscarTodosDocentesPaginados(Pageable pageable) {
        return docenteRepository.findAll(pageable);
    }

    @Override
    public List<Docentes> ObtenerDocentesTodos() {
        return docenteRepository.findAll();
    }

    @Override
    public Optional<Docentes> BuscarDocentesPorId(Integer id) {
        return docenteRepository.findById(id);

    }

    @Override
    public Docentes CrearDocentesOeditar(Docentes grupos) {
        return docenteRepository.save(grupos);

    }

    @Override
    public void EliminarDocentesPorId(Integer id) {
        docenteRepository.deleteById(id);
    }
}


