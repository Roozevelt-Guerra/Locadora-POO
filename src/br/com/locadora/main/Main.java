package br.com.locadora.main;

import br.com.locadora.enumeradores.EnumDisponibilidadeDeFilme;
import br.com.locadora.model.Filme;

public class Main {
    public static void main(String[] args) {
        Filme filme = new Filme("2525",
                "A volta dos que não foram",
                EnumDisponibilidadeDeFilme.DISPONIVEL);

        System.out.println(filme);
    }
}
