package br.com.locadora.model;

import br.com.locadora.contratos.ILocadora;
import br.com.locadora.enumeradores.EnumDisponibilidadeDeFilme;

import java.util.Arrays;

public class Locadora implements ILocadora {
    private Filme[] acervo;
    private int quantidadeFilmesInseridos;

    private Filme[] emprestimo;
    private int quantidadeEmprestimosRealizados;

    private Filme[] reservas;
    private int quantidadeReservasRealizadas;

    public Locadora(int limiteFilmes,
                    int limiteEmprestimos,
                    int limiteReservas) {
        this.acervo = new Filme[limiteFilmes];
        this.emprestimo = new Filme[limiteEmprestimos];
        this.reservas = new Filme[limiteReservas];
    }


    @Override
    public Filme BuscarFilmePorCodigo(String codigoFilme) {
        for (int i = 0; i < acervo.length; i++) {
            if (this.acervo[i] != null && this.acervo[i].getCodigo().equals(codigoFilme)){
                return this.acervo[i];
            }
        }
        return null;
    }

    @Override
    public boolean inserir(Filme filme) {
        if (this.quantidadeFilmesInseridos == this.acervo.length){
            System.out.println("Acervo está cheio");
            return false;
        }
        for (int i = 0; i < this.acervo.length; i++) {
            if (this.acervo[i] == null){
                this.acervo[i] = filme;
                this.quantidadeFilmesInseridos++;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removerFilmePorCodigo(String codigoFilme) {
        if (verificarDisponibilidade(codigoFilme) == EnumDisponibilidadeDeFilme.DISPONIVEL){
            for (int i = 0; i < this.acervo.length; i++) {
                if (this.acervo[i] != null && this.acervo[i].getCodigo().equals(codigoFilme) ){
                    this.acervo[i] = null;
                    this.quantidadeFilmesInseridos--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean emprestar(String codigoFilme) {
        if (this.quantidadeReservasRealizadas == this.reservas.length){
            System.out.println("máxima de reservas possíveis");
            return false;
        }
        if (verificarDisponibilidade(codigoFilme) == EnumDisponibilidadeDeFilme.DISPONIVEL){
            Filme filme = buscarFilmePorCodigo(codigoFilme);

            for (int i = 0; i < emprestimo.length; i++) {
                if (this.emprestimo[i] == null){
                    this.emprestimo[i] = filme;
                    this.quantidadeEmprestimosRealizados++;
                    break;
                }
            }

            for (int i = 0; i < this.acervo.length; i++) {
                if (this.acervo[i] != null && this.acervo[i].getCodigo().equals(codigoFilme)){
                    this.acervo[i].setDisponibilidade(EnumDisponibilidadeDeFilme.EMPRESTADO);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean devolver(String codigoFilme) {
        for (int i = 0; i < this.emprestimo.length; i++) {
            if (this.emprestimo[i] != null && this.emprestimo[i].getCodigo().equals(codigoFilme)){
                this.emprestimo[i] = null;
                this.quantidadeEmprestimosRealizados--;
                break;
            }

        }

        for (int i = 0; i < this.acervo.length; i++) {
            if (this.acervo[i] != null && this.acervo[i].getCodigo().equals(codigoFilme)){
                this.acervo[i].setDisponibilidade(EnumDisponibilidadeDeFilme.DISPONIVEL);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean reservar(String codigoFilme) {
        if (this.quantidadeReservasRealizadas == this.reservas.length){
            System.out.println("Máximas de reservas possíveis");
            return false;
        }
        if (verificarDisponibilidade(codigoFilme) == EnumDisponibilidadeDeFilme.DISPONIVEL ){
            Filme filme = buscarFilmePorCodigo(codigoFilme);

            for (int i = 0; i < this.reservas.length; i++){
                if (this.reservas[i] == null){
                    this.reservas[i] = filme;
                    this.quantidadeReservasRealizadas++;
                    break;
                }
            }

            for (int i = 0; i < this.acervo.length; i++) {
                if (this.acervo[i] != null && this.acervo[i].getCodigo().equals(codigoFilme)){
                    this.acervo[i].setDisponibilidade(EnumDisponibilidadeDeFilme.RESERVADO);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public EnumDisponibilidadeDeFilme verificarDisponibilidade(String codigoFilme) {
        for (int i = 0; i < this.acervo.length; i++) {
            if (this.acervo[i] != null && this.acervo[i].getCodigo().equals(codigoFilme))
                return this.acervo[i].getDisponibilidade();
        }
        return null;
    }

    public int getQuantidadeFilmesInseridos() {
        return quantidadeFilmesInseridos;
    }

    public int getQuantidadeEmprestimosRealizados() {
        return quantidadeEmprestimosRealizados;
    }

    public int getQuantidadeReservasRealizadas() {
        return quantidadeReservasRealizadas;
    }

    @Override
    public String toString() {
        return "Locadora{" +
                "acervo=" + Arrays.toString(acervo) +
                ", quantidadeFilmesInseridos=" + quantidadeFilmesInseridos +
                ", emprestimo=" + Arrays.toString(emprestimo) +
                ", quantidadeEmprestimosRealizados=" + quantidadeEmprestimosRealizados +
                ", reservas=" + Arrays.toString(reservas) +
                ", quantidadeReservasRealizadas=" + quantidadeReservasRealizadas +
                '}';
    }
}
