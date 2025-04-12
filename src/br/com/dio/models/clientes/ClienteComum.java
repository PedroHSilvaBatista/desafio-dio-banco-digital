package br.com.dio.models.clientes;

public class ClienteComum extends Cliente {
    private final double cashback;

    public ClienteComum(String nome, int idade, String sigla) {
        super(nome, idade, sigla);
        cashback = 0.01;
    }

    @Override
    public void exibirInformacoesCliente() {

    }
}
