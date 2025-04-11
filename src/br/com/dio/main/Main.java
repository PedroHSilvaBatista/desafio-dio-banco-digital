package br.com.dio.main;

import br.com.dio.models.contas.ContaCorrente;
import br.com.dio.models.contas.ContaPoupanca;
import br.com.dio.models.contas.exceptions.ExcedeLimiteException;
import br.com.dio.models.contas.exceptions.SaldoInsuficienteException;
import br.com.dio.models.contas.exceptions.ValorNegativoException;
import br.com.dio.models.contas.exceptions.ValorZeroException;

public class Main {
    public static void main(String[] args) {
        ContaPoupanca cp = new ContaPoupanca(null);
        ContaCorrente cc = new ContaCorrente(null);

        try {
            System.out.println(cp.getSaldo());
            cp.depositar(10);
            cp.sacar(5);
            cp.imprimirExtrato();
            cp.transferir(2, cc);

            cc.imprimirExtrato();
            cc.depositar(10);
            cc.sacar(4);
            System.out.println(cc.getSaldo());
        } catch (SaldoInsuficienteException | ExcedeLimiteException | ValorZeroException | ValorNegativoException e) {
            System.out.println(e.getMessage());
        }

    }
}
