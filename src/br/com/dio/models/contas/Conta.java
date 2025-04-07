package br.com.dio.models.contas;

public class Conta {
    private static final int AGENCIA_PADRAO=1;
    private static int sequencial = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    // protected Cliente cliente;

    public Conta() {
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
}
