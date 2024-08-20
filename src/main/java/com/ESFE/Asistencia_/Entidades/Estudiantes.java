package com.ESFE.Asistencia_.Entidades;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estudiantes")
public class Estudiantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Ingrese el nombre del estudiante")
    private String nombre;

    @NotBlank(message = "Ingrese el correo del docente")
    private String correo;

    @NotBlank(message = "Ingrese el pin del docente")
    private String pin;


    @OneToMany(mappedBy = "estudiante")
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

    public @NotBlank(message = "Ingrese el nombre del estudiante") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "Ingrese el nombre del estudiante") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "Ingrese el correo del docente") String getCorreo() {
        return correo;
    }

    public void setCorreo(@NotBlank(message = "Ingrese el correo del docente") String correo) {
        this.correo = correo;
    }

    public @NotBlank(message = "Ingrese el pin del docente") String getPin() {
        return pin;
    }

    public void setPin(@NotBlank(message = "Ingrese el pin del docente") String pin) {
        this.pin = pin;
    }
}
