package br.com.dio.models.clientes;

public final class ClienteComum extends Cliente {
    private final double cashback;

    public ClienteComum(String nome, int idade, String sigla) {
        super(nome, idade, sigla);
        cashback = 0.01;
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
        System.out.println("==============================================");
    }
}
