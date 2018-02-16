package com.github.lucasjalves.livrosshop.domain.entities;

public class Livro extends AbstractEntidade {
    private String autor;
    private int ano;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
