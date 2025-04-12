package br.com.dio.models.clientes;

import java.util.List;
import java.util.Arrays;

public final class ClienteVIP extends Cliente {
    private final double cashback;
    private final List<String> servicosDisponiveis;

    public ClienteVIP(String nome, int idade, String sigla) {
        super(nome, idade, sigla);
        cashback = 0.05;
        servicosDisponiveis = Arrays.asList("Streaming", "Desconto em Roupas", "Cinema", "Desconto em Restaurantes");
    }

    public double getCashback() {
        return cashback;
    }

    @Override
    public void exibirInformacoesCliente() {
        System.out.println("==============================================");
        System.out.println("INFORMAÇÕES DO CLIENTE");
        super.exibirInfosComuns();
        System.out.printf("Cashback: %.1f%%%n", cashback * 100);
        System.out.println("Serviços disponíveis: "); servicosDisponiveis.forEach(System.out::print);
        System.out.println("==============================================");
    }
}
