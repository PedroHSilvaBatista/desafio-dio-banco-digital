package br.com.dio.main;

import br.com.dio.models.banco.Banco;
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

        // Instanciando um objeto da classe banco
        Banco banco = new Banco("Banco X");

        // Declarando os clientes Comum e VIP
        ClienteComum clienteComum;
        ClienteVIP clienteVIP;

        // Declarando as contas Poupança e Corrente
        ContaPoupanca contaPoupanca;
        ContaCorrente contaCorrente;

        try {
            // Instanciando os cliente Comum e VIP
            clienteComum = new ClienteComum("Vitor", 22, "RS");
            clienteVIP = new ClienteVIP("Maria", 32, "AM");

            // Caso as informações estejam corretas a execução do código continuará
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Instanciando as contas Poupança e Corrente para que elas possam ser inicializadas corretamente
        contaPoupanca = new ContaPoupanca(clienteComum);
        contaCorrente = new ContaCorrente(clienteVIP);

        // OBS: A instanciação do objeto da classe Poupança poderia também ser inicializada por um objeto da classe VIP,
        //      assim como a instanciação da classe Corrente poderia ser inicializada por um objeto da classe Comum

        try {
            // Testando os métodos das classes

            // Testando os métodos da classe Poupança e do cliente Comum
            contaPoupanca.depositar(1000);
            contaPoupanca.sacar(200);
            contaPoupanca.transferir(100, contaCorrente);
            contaPoupanca.pagarConta(50);
            contaPoupanca.imprimirExtrato();
            clienteComum.exibirInformacoesCliente();

            // Testando os métodos da classe Corrente e do cliente VIP
            contaCorrente.depositar(2000);
            contaCorrente.sacar(500);
            contaCorrente.transferir(75, contaPoupanca);
            contaCorrente.pagarConta(100);
            contaCorrente.imprimirExtrato();
            clienteVIP.exibirInformacoesCliente();

            // Testando os métodos da classe Banco
            banco.adicionarConta(contaCorrente);
            banco.adicionarConta(contaPoupanca);

            banco.exibirContasPorSaldo();
            banco.exibirContasPorNome();

        } catch (SaldoInsuficienteException | ExcedeLimiteException | ValorZeroException | ValorNegativoException e) {
            System.out.println(e.getMessage());
        }
    }
}
