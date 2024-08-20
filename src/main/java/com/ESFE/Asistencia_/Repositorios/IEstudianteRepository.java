package com.ESFE.Asistencia_.Repositorios;

import com.ESFE.Asistencia_.Entidades.Docentes;
import com.ESFE.Asistencia_.Entidades.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudianteRepository extends JpaRepository<Estudiantes, Integer> {
}
