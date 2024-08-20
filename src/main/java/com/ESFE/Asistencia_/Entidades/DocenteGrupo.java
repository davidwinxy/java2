package com.ESFE.Asistencia_.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "docentes_grupos")
public class DocenteGrupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docentes docente;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupos grupo;

    private int año;
    private String ciclo;

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Docentes getDocente() {
        return docente;
    }

    public void setDocente(Docentes docente) {
        this.docente = docente;
    }

    public Grupos getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupos grupo) {
        this.grupo = grupo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
}


