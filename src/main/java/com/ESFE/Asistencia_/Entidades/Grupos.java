package com.ESFE.Asistencia_.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "grupos")
public class Grupos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Ingrese el nombre del grupo")
    private String nombre;

    @NotBlank(message = "Ingrese la descripción del grupo")
    private String descripcion;

    @OneToMany(mappedBy = "grupo")
    private Set<DocenteGrupo> docenteGrupos = new HashSet<>();

    @OneToMany(mappedBy = "grupo")
    private Set<EstudianteGrupo> estudianteGrupos = new HashSet<>();

    public Set<EstudianteGrupo> getEstudianteGrupos() {
        return estudianteGrupos;
    }

    public void setEstudianteGrupos(Set<EstudianteGrupo> estudianteGrupos) {
        this.estudianteGrupos = estudianteGrupos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<DocenteGrupo> getDocenteGrupos() {
        return docenteGrupos;
    }

    public void setDocenteGrupos(Set<DocenteGrupo> docenteGrupos) {
        this.docenteGrupos = docenteGrupos;
    }
}


