package com.ESFE.Asistencia_.Servicios.Implementaciones;


import com.ESFE.Asistencia_.Entidades.DocenteGrupo;
import com.ESFE.Asistencia_.Entidades.Docentes;
import com.ESFE.Asistencia_.Repositorios.IDocenteGrupoRepository;
import com.ESFE.Asistencia_.Repositorios.IDocenteRepository;
import com.ESFE.Asistencia_.Servicios.Inerfaces.IDocenteGrupoServices;
import com.ESFE.Asistencia_.Servicios.Inerfaces.IDocentesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DocenteGrupoServices implements IDocenteGrupoServices {

    @Autowired
    private IDocenteGrupoRepository docenteGrupoRepository;


    public Page<DocenteGrupo> BuscarTodosPaginados(Pageable pageable){
        return docenteGrupoRepository.findByOrderByDocenteDesc(pageable);
    }

    @Override
    public List<DocenteGrupo> ObtenerTodos() {
        return docenteGrupoRepository.findAll();
    }

    @Override
    public Optional<DocenteGrupo> BuscarPorId(Integer id) {
        return docenteGrupoRepository.findById(id);
    }

    @Override
    public DocenteGrupo CrearOeditar(DocenteGrupo docenteGrupo) {
        return docenteGrupoRepository.save(docenteGrupo);
    }

    @Override
    public void EliminarPorId(Integer id) {
        docenteGrupoRepository.deleteById(id);
    }

}


