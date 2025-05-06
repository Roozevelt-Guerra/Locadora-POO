package br.com.locadora.model;

import br.com.locadora.enumeradores.EnumDisponibilidadeDeFilme;

public class Filme {
    private String codigo;
    private String titulo;
    private EnumDisponibilidadeDeFilme disponibilidade;

    public Filme(String codigo,
                 String titulo,
                 EnumDisponibilidadeDeFilme disponibilidade) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponibilidade = disponibilidade;


    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public EnumDisponibilidadeDeFilme getDisponibilidade() {
        return this.disponibilidade;
    }

    public void setDisponibilidade(EnumDisponibilidadeDeFilme disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}
