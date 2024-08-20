package com.ESFE.Asistencia_.Entidades;


import jakarta.persistence.*;

@Entity
@Table(name = "estudiante_grupos")
public class EstudianteGrupo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiantes estudiante;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupos grupo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estudiantes getEstudiantes() {
        return estudiante;
    }

    public Estudiantes getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiantes estudiante) {
        this.estudiante = estudiante;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiante = estudiantes;
    }

    public Grupos getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupos grupo) {
        this.grupo = grupo;
    }
}
