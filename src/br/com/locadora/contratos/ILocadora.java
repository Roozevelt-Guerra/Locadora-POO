package br.com.locadora.contratos;

import br.com.locadora.enumeradores.EnumDisponibilidadeDeFilme;
import br.com.locadora.model.Filme;

public interface ILocadora {
    Filme BuscarFilmePorCodigo(String codigoFilme);
    boolean inserir(Filme filme);
    boolean removerFilmePorCodigo(String codigoFilme);
    boolean emprestar(String codigoFilme);
    boolean devolver(String codigoFilme);
    boolean reservar(String codigoFilme);
    EnumDisponibilidadeDeFilme verificarDisponibilidade(String codigoFilme);

}
