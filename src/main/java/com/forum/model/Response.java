package com.forum.model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;

@Entity
@Table(name = "responses")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private Topic topico;
    private Data dataCriacao;
    private User autor;
    private String solucao;

}
