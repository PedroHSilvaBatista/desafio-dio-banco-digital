package br.com.dio.models.contas;

import br.com.dio.models.clientes.Cliente;
import br.com.dio.models.clientes.ClienteComum;

public final class ContaCorrente extends Conta {
    // TODO: Criar as classes de Exceções Personalizadas

    // TODO: Após terminar de modelar a classe ContaCorrente, comece a modelar a classe Cliente

    private final double LIMITE;


    public ContaCorrente(Cliente cliente) {
        super(cliente);

        if (cliente instanceof ClienteComum) {
            LIMITE = 150;
        } else {
            LIMITE = 500;
        }
    }

    // Métodos básicos da classe
    @Override
    public void sacar(double valorDeSaque) {
        if (valorDeSaque > 0) {
            if (saldo - valorDeSaque >= -LIMITE) {
                saldo -= valorDeSaque;
                System.out.printf("Saque realizado: %.2f%n", valorDeSaque);
            } else {
                // throws ExceptionPersonalizada (Saque inválido: Excede limite)
                System.out.println("Valor excede o limite");
            }
        } else if (valorDeSaque == 0) {
            // throws ExceptionPersonalizada (Insira um valor para realizar a operação)
            System.out.println();
        } else {
            // throws ExceptionPersonalizada (Insira um valor positivo)
            System.out.println();
        }
    }

    @Override
    public void imprimirExtrato() {
        super.exibirInfosComuns();
        System.out.printf("Limite da conta: R$%.2f%n", LIMITE);
    }
}
