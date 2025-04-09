package br.com.dio.models.contas;

import br.com.dio.models.clientes.Cliente;

public abstract sealed class Conta implements IConta permits ContaCorrente {

    // TODO: Criar um método abstrato de imprimirExtrato

    private static final int AGENCIA_PADRAO=1;
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
        saldo -= valorDeSaque;
    }

    @Override
    public void depositar(double valorDeDeposito) {
        saldo += valorDeDeposito;
    }

    @Override
    public void transferir(double valorDeTransferencia, Conta conta) {
        this.sacar(valorDeTransferencia);
        conta.depositar(valorDeTransferencia);
    }

    public void exibirInfosComuns() {
        System.out.println("Agência: " + this.agencia);
        System.out.println("Numero: " + this.numero);
        System.out.printf("Saldo: R$%.2f%n", this.saldo);
    }

    protected abstract void imprimirExtrato();
}
