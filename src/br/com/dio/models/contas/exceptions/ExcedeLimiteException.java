package br.com.dio.models.contas.exceptions;

public class ExcedeLimiteException extends Exception {
    private String message;

    public ExcedeLimiteException () {
        this.message = "Saque Inválido: Excede Limite";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
