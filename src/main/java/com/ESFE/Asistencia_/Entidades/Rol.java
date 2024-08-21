package com.ESFE.Asistencia_.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "roles")
public class Rol {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "es requerido") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "es requerido") String nombre) {
        this.nombre = nombre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "es requerido")
    private String nombre;
}
