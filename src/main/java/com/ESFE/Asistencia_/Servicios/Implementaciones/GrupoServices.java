package com.ESFE.Asistencia_.Servicios.Implementaciones;

import com.ESFE.Asistencia_.Entidades.Grupos;
import com.ESFE.Asistencia_.Repositorios.IGrupoRepository;
import com.ESFE.Asistencia_.Servicios.Inerfaces.IGruposServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GrupoServices implements IGruposServices {


    @Autowired
private IGrupoRepository grupoRepository;

    @Override
    public Page<Grupos> BuscarTodosPaginados(Pageable pageable) {
        return grupoRepository.findAll(pageable);
    }

    @Override
    public List<Grupos> ObtenerTodos() {
        return grupoRepository.findAll();
    }

    @Override
    public Optional<Grupos> BuscarPorId(Integer id) {
        return grupoRepository.findById(id);

    }

    @Override
    public Grupos CrearOeditar(Grupos grupos) {
        return grupoRepository.save(grupos);

    }

    @Override
    public void EliminarPorId(Integer id) {
grupoRepository.deleteById(id);
    }
}
