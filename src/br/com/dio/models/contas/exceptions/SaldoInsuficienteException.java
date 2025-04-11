package br.com.dio.models.contas.exceptions;

public class SaldoInsuficienteException extends  Exception {
    private String message;

    public SaldoInsuficienteException() {
        this.message = "Saque Inválido: Saldo Insuficiente";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
