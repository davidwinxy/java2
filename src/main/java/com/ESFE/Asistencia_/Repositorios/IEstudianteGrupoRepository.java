package com.ESFE.Asistencia_.Repositorios;

import com.ESFE.Asistencia_.Entidades.DocenteGrupo;
import com.ESFE.Asistencia_.Entidades.EstudianteGrupo;
import com.ESFE.Asistencia_.Entidades.Estudiantes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudianteGrupoRepository extends JpaRepository<EstudianteGrupo, Integer> {
    Page<EstudianteGrupo> findByOrderByEstudianteDesc(Pageable pageable);

}
