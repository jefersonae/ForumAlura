package com.forum.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private Date dataCriacao;
    private Boolean status;
    private User autor;
    private Course curso;
    private Response respostas;

}
