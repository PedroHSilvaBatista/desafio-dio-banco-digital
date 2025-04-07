package br.com.dio.models.contas;

public interface IConta {

    void sacar(double valorDeSaque);

    void depositar(double valorDeDeposito);

    void transferir(double valorTransferencia, Conta conta);
}
