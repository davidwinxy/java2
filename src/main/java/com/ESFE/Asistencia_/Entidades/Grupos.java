package com.ESFE.Asistencia_.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "Grupos")
public class Grupos  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotBlank(message = "ingrese el nombre del grupo")
    private String nombre;

    @NotNull
    private String descripcion;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public @NotBlank(message = "ingrese el nombre del grupo") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "ingrese el nombre del grupo") String nombre) {
        this.nombre = nombre;
    }

    public @NotNull String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotNull String descripcion) {
        this.descripcion = descripcion;
    }
}
