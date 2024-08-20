package com.ESFE.Asistencia_.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "docentes")
public class Docentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Ingrese el nombre del docente")
    private String nombre;

    @NotBlank(message = "Ingrese el apellido del docente")
    private String apellido;

    @NotBlank(message = "Ingrese el email del docente")
    private String email;

    @NotBlank(message = "Ingrese el teléfono del docente")
    private String telefono;

    @NotBlank(message = "Ingrese la escuela del docente")
    private String escuela;

    @OneToMany(mappedBy = "docente")
    private Set<DocenteGrupo> docenteGrupos = new HashSet<>();



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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public Set<DocenteGrupo> getDocenteGrupos() {
        return docenteGrupos;
    }

    public void setDocenteGrupos(Set<DocenteGrupo> docenteGrupos) {
        this.docenteGrupos = docenteGrupos;
    }
}




