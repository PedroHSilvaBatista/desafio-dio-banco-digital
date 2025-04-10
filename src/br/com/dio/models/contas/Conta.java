package br.com.dio.models.contas;

import br.com.dio.models.clientes.Cliente;

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
    public void sacar(double valorDeSaque) {
        if (valorDeSaque > 0) {
            if (saldo >= valorDeSaque) {
                saldo -= valorDeSaque;
            } else {
                // throws ExceptionPersonalizada (Saque inválido: Saldo insuficiente)
                System.out.println();
            }
        } else if (valorDeSaque == 0) {
            // throws ExceptionPersonalizada (Insira um valor para realizar a operação)
            System.out.println();
        } else {
            // throws ExceptionPersonalizada (Insira um valor positivo)
            System.out.println();
        }

        saldo -= valorDeSaque;
    }

    @Override
    public void depositar(double valorDeDeposito) {
        if (valorDeDeposito > 0) {
            saldo += valorDeDeposito;
        } else if (valorDeDeposito == 0 ){
            // throws ExceptionPersonalizada (Insira um valor para realizar a operação)
            System.out.println();
        } else {
            // throws ExceptionPersonalizada (Insira um valor positivo)
            System.out.println();
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

    public void exibirInfosComuns() {
        System.out.println("Agência: " + this.agencia);
        System.out.println("Numero: " + this.numero);
        System.out.printf("Saldo: R$%.2f%n", this.saldo);
    }

    protected abstract void imprimirExtrato();
}
