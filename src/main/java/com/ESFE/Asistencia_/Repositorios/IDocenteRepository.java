package com.ESFE.Asistencia_.Repositorios;

import com.ESFE.Asistencia_.Entidades.Docentes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocenteRepository extends JpaRepository<Docentes, Integer> {
}
