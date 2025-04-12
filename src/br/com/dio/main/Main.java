package br.com.dio.main;

import br.com.dio.models.clientes.ClienteComum;
import br.com.dio.models.clientes.ClienteVIP;
import br.com.dio.models.contas.ContaCorrente;
import br.com.dio.models.contas.ContaPoupanca;
import br.com.dio.models.contas.exceptions.ExcedeLimiteException;
import br.com.dio.models.contas.exceptions.SaldoInsuficienteException;
import br.com.dio.models.contas.exceptions.ValorNegativoException;
import br.com.dio.models.contas.exceptions.ValorZeroException;

public class Main {
    public static void main(String[] args) {
        // TESTES MOCADOS

        ClienteComum clienteComum;
        ClienteVIP clienteVIP;
        ContaPoupanca cp;
        ContaCorrente cc;

        try {
            clienteComum = new ClienteComum("Márcio", 22, "RS");
            clienteComum.exibirInformacoesCliente();

            clienteVIP = new ClienteVIP("Maria", 32, "AM");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        cp = new ContaPoupanca(clienteComum);
        cc = new ContaCorrente(clienteVIP);

        try {
            cp.depositar(10);
            cp.sacar(5);
            cp.imprimirExtrato();
            cp.transferir(2, cc);

            cc.imprimirExtrato();
            cc.depositar(10);
            cc.sacar(4);
        } catch (SaldoInsuficienteException | ExcedeLimiteException | ValorZeroException | ValorNegativoException e) {
            System.out.println(e.getMessage());
        }

    }
}
