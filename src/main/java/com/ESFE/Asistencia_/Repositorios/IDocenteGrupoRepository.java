package com.ESFE.Asistencia_.Repositorios;

import com.ESFE.Asistencia_.Entidades.DocenteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface IDocenteGrupoRepository extends JpaRepository<DocenteGrupo, Integer> {
    Page<DocenteGrupo> findByOrderByDocenteDesc(Pageable pageable);
}
