package br.com.dio.models.contas;

import java.util.Comparator;

public class ComparatorPorNome implements Comparator<Conta> {
    @Override
    public int compare(Conta conta1, Conta conta2) {
        return conta1.cliente.getNome().compareToIgnoreCase(conta2.cliente.getNome());
    }
}
