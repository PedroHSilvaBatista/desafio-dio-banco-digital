package br.com.dio.models.contas.exceptions;

public class ValorNegativoException extends Exception{
    private String message;

    public ValorNegativoException() {
        this.message = "Para realizar a operação é necessário informar um valor positivo";
    }

    public ValorNegativoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
