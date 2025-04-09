package br.com.dio.models.contas;

import br.com.dio.models.clientes.Cliente;
import br.com.dio.models.clientes.ClienteComum;

public final class ContaCorrente extends Conta {

    // TODO: Terminar de modelar a classe ContaCorrente sobrescrevendo os métodos básicos da conta

    // TODO: Criar as classes de Exceçções Personalizadas

    // TODO: Após terminar de modelar a classe ContaCorrente, comece a modelar a classe Cliente

    private double limite;


    public ContaCorrente(Cliente cliente) {
        super(cliente);

        if (cliente instanceof ClienteComum) {
            limite = 150;
        } else {
            limite = 500;
        }
    }

    // Métodos básicos da classe
    @Override
    public void sacar(double valorDeSaque) {
        if (valorDeSaque > 0) {
            if (saldo - valorDeSaque >= -limite) {
                saldo -= valorDeSaque;
                System.out.printf("Saque realizado: %.2f%n", valorDeSaque);
            } else {
                // throws ExceptionPersonalizada (Excede Limite)
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
    public void depositar(double valorDeDeposito) {
        // Criar uma exceção para quando o valor for negativo ou zero
        if (valorDeDeposito >= 0) {
            saldo += valorDeDeposito;
        } else {
            // throws ExceptionPersonalizada
            System.out.println("Não é possível realizar depósitos com valores negativos");
        }
    }

    @Override
    public void transferir(double valorDeTransferencia, Conta conta) {
        if (valorDeTransferencia > 0) {
            this.sacar(valorDeTransferencia);
            conta.depositar(valorDeTransferencia);
        } else if (valorDeTransferencia == 0) {
            // throws ExceptionPersonalizada (Insira um valor para realizar a operação)
            System.out.println();
        } else {
            // throws ExceptionPersonalizada (Insira um valor positivo)
            System.out.println();
        }
    }

    @Override
    public void imprimirExtrato(){
        super.exibirInfosComuns();
        System.out.printf("Limite da conta: R$%.2f%n", limite);
    }
}
