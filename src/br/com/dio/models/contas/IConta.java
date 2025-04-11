package br.com.dio.models.contas;

import br.com.dio.models.contas.exceptions.ExcedeLimiteException;
import br.com.dio.models.contas.exceptions.SaldoInsuficienteException;
import br.com.dio.models.contas.exceptions.ValorNegativoException;
import br.com.dio.models.contas.exceptions.ValorZeroException;

public interface IConta{

    void sacar(double valorDeSaque) throws SaldoInsuficienteException, ExcedeLimiteException,
            ValorNegativoException, ValorZeroException;

    void depositar(double valorDeDeposito) throws ValorNegativoException, ValorZeroException;

    void transferir(double valorTransferencia, Conta conta) throws SaldoInsuficienteException,
            ExcedeLimiteException, ValorNegativoException, ValorZeroException;
}
