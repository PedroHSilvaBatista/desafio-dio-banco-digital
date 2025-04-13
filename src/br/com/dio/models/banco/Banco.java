package br.com.dio.models.banco;

import br.com.dio.models.contas.ComparatorPorNome;
import br.com.dio.models.contas.Conta;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco (String nome) {
        this.nome = nome;
        contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
        System.out.println("Conta adicionada com sucesso!");
    }

    public void exibirContasPorSaldo() {
        if (! contas.isEmpty()) {
            Collections.sort(contas);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Lista de contas registradas no banco e ordenadas por saldo");
            contas.forEach(System.out::println);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
            return;
        }
        System.out.println("Não foi encontrada nenhuma conta registrada no banco " + nome);
    }

    public void exibirContasPorNome() {
        if (! contas.isEmpty()) {
            contas.sort(new ComparatorPorNome());
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Lista de contas registradas no banco e ordenadas por nome");
            contas.forEach(System.out::println);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
            return;
        }
        System.out.println("Não foi encontrada nenhuma conta registrada no banco " + nome);
    }
}