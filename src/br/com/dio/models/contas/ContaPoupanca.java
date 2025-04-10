package br.com.dio.models.contas;

import br.com.dio.models.clientes.Cliente;
import br.com.dio.models.clientes.ClienteComum;

import java.time.LocalDate;

public final class ContaPoupanca extends Conta {
    // TODO: Terminar de modelar a classe ContaPoupanca sobrescrevendo os métodos básicos da conta

    // TODO: Após terminar de modelar a classe ContaPoupanca, comece a modelar a classe Cliente

    private final double TR = 0.0017;
    private final double JUROS;
    private LocalDate dataAtual;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);

        if (cliente instanceof ClienteComum) {
            JUROS = 0.005;
        } else {
            JUROS = 0.015;
        }
        gerarJurosSobreSaldoPorDia();
    }

    // Simulação do rendimento da conta por dias
    private void gerarJurosSobreSaldoPorDia() {
        int dia = 9;
        int mes = 4;
        int ano = 2025;

        int diaAtual = dataAtual.getDayOfMonth();
        int mesAtual = dataAtual.getMonthValue();
        int anoAtual = dataAtual.getYear();

        if (dia != diaAtual && mes != mesAtual && ano != anoAtual) {
            int mesParaDias = mes * 30, mesAtualParaDias = mesAtual * 30;
            int anoParaDias = ano * 365, anoAtualParaDias = anoAtual * 365;

            int diasTranscorridos = (diaAtual + mesAtualParaDias + anoAtualParaDias) - (dia + mesParaDias + anoParaDias);
            double jurosAcumulados = (JUROS + TR) * diasTranscorridos;
            saldo += jurosAcumulados;
        }
    }

    @Override
    public void imprimirExtrato() {
        super.exibirInfosComuns();
        System.out.printf("Valor do juros da conta: %.2f%n", JUROS * 100);
    }
}
