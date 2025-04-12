package br.com.dio.models.contas;

import br.com.dio.models.clientes.Cliente;
import br.com.dio.models.clientes.ClienteComum;
import br.com.dio.models.clientes.ClienteVIP;
import br.com.dio.models.contas.exceptions.ExcedeLimiteException;
import br.com.dio.models.contas.exceptions.SaldoInsuficienteException;
import br.com.dio.models.contas.exceptions.ValorNegativoException;
import br.com.dio.models.contas.exceptions.ValorZeroException;

public abstract sealed class Conta implements IConta permits ContaCorrente, ContaPoupanca {
    private static final int AGENCIA_PADRAO = 1;
    private static int sequencial = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
        this.numero = sequencial++;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valorDeSaque) throws SaldoInsuficienteException, ExcedeLimiteException, ValorZeroException, ValorNegativoException {

        if (valorDeSaque > 0) {
            if (saldo >= valorDeSaque) {
                saldo -= valorDeSaque;
            } else {
                throw new SaldoInsuficienteException();
            }
        } else if (valorDeSaque == 0) {
            throw new ValorZeroException();
        } else {
            throw new ValorNegativoException();
        }

    }

    @Override
    public void depositar(double valorDeDeposito) throws ValorZeroException, ValorNegativoException {
        if (valorDeDeposito > 0) {
            saldo += valorDeDeposito;
        } else if (valorDeDeposito == 0) {
            throw new ValorZeroException();
        } else {
            throw new ValorNegativoException();
        }
    }

    public void pagarConta(double valorDaConta) throws SaldoInsuficienteException, ExcedeLimiteException, ValorZeroException, ValorNegativoException {
        if (valorDaConta > 0) {
            if (saldo >= valorDaConta) {
                saldo -= valorDaConta;
                if (cliente instanceof ClienteComum comum) {
                    saldo += (valorDaConta * comum.getCashback());
                } else if (cliente instanceof ClienteVIP vip) {
                    saldo += (valorDaConta * vip.getCashback());
                }
            } else {
                throw new SaldoInsuficienteException();
            }
        } else if (valorDaConta == 0) {
            throw new ValorZeroException();
        } else {
            throw new ValorNegativoException();
        }
    }

    @Override
    public void transferir(double valorDeTransferencia, Conta conta) throws ExcedeLimiteException, SaldoInsuficienteException, ValorZeroException, ValorNegativoException {
        if (valorDeTransferencia > 0) {
            this.sacar(valorDeTransferencia);
            conta.depositar(valorDeTransferencia);
        } else if (valorDeTransferencia == 0) {
            throw new ValorZeroException();
        } else {
            throw new ValorNegativoException();
        }
    }

    public void exibirInfosComuns() {
        System.out.println("Titular da conta: " + cliente.getNome());
        System.out.println("Agência: " + this.agencia);
        System.out.println("Numero: " + this.numero);
        System.out.printf("Saldo: R$%.2f%n", this.saldo);
    }

    protected abstract void imprimirExtrato();
}
