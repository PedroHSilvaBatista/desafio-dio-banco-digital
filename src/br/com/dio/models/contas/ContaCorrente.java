package br.com.dio.models.contas;

import br.com.dio.models.clientes.Cliente;
import br.com.dio.models.clientes.ClienteComum;
import br.com.dio.models.contas.exceptions.ExcedeLimiteException;
import br.com.dio.models.contas.exceptions.ValorNegativoException;
import br.com.dio.models.contas.exceptions.ValorZeroException;

public final class ContaCorrente extends Conta {
    // TODO: Comece a modelar a classe Cliente

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
    public void sacar(double valorDeSaque) throws ExcedeLimiteException, ValorNegativoException, ValorZeroException {
        if (valorDeSaque > 0) {
            if (saldo - valorDeSaque >= -LIMITE) {
                saldo -= valorDeSaque;
                System.out.printf("Saque realizado: %.2f%n", valorDeSaque);
            } else {
                throw new ExcedeLimiteException();
            }
        } else if (valorDeSaque == 0) {
            throw new ValorZeroException();
        } else {
            throw new ValorNegativoException("Para realizar a operação é necessário informar um valor positivo");
        }
    }

    @Override
    public void transferir(double valorDeTransferencia, Conta conta) throws ExcedeLimiteException, ValorNegativoException, ValorZeroException {
        if (valorDeTransferencia > 0) {
            this.sacar(valorDeTransferencia);
            conta.depositar(valorDeTransferencia);
        } else if (valorDeTransferencia == 0) {
            throw new ValorZeroException();
        } else {
            throw new ValorNegativoException();
        }
    }

    @Override
    public void imprimirExtrato() {
        super.exibirInfosComuns();
        System.out.printf("Limite da conta: R$%.2f%n", LIMITE);
    }
}
