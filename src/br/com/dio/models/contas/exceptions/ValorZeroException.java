package br.com.dio.models.contas.exceptions;

public class ValorZeroException extends Exception{
    private String message;

    public ValorZeroException() {
        this.message = "Insira um valor para realizar a operação";
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
