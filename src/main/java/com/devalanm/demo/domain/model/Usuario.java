package com.devalanm.demo.domain.model;

public class Usuario {

    private Long id;
    private String nome;

    public Usuario(Long id, String nome) {
        if (id == null) {
            throw new IllegalArgumentException("Id invalido");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome invalido");
        }
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean temNome(String nome) {
        return this.nome.equals(nome);
    }
}
