package com.ESFE.Asistencia_.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "docentes")
public class Docentes {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotBlank(message = "ingrese el nombre del Docente")
    private String nombre;

    @NotBlank(message = "ingrese el apellido del docente")
    private String apellido;

    @NotBlank(message = "ingrese el email del docente")
    private String email;

    @NotBlank(message = "ingrese el telefono del docente")
    private String telefono;

    @NotBlank(message = "ingrese la escuela del docente")
    private String escuela;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public @NotBlank(message = "ingrese el nombre del Docente") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "ingrese el nombre del Docente") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "ingrese el apellido del docente") String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank(message = "ingrese el apellido del docente") String apellido) {
        this.apellido = apellido;
    }

    public @NotBlank(message = "ingrese el email del docente") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "ingrese el email del docente") String email) {
        this.email = email;
    }

    public @NotBlank(message = "ingrese el telefono del docente") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotBlank(message = "ingrese el telefono del docente") String telefono) {
        this.telefono = telefono;
    }

    public @NotBlank(message = "ingrese la escuela del docente") String getEscuela() {
        return escuela;
    }

    public void setEscuela(@NotBlank(message = "ingrese la escuela del docente") String escuela) {
        this.escuela = escuela;
    }
}



