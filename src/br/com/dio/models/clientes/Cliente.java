package br.com.dio.models.clientes;


public abstract class Cliente {
    private String nome;
    private int idade;
    private UnidadesFederativas unidadeFederativa;

    public Cliente(String nome, int idade, String sigla) {
        this.nome = nome;
        this.idade = idade;
        this.unidadeFederativa = UnidadesFederativas.encontrarUFPorSigla(sigla);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void getUnidadeFederativa() {
        System.out.println(unidadeFederativa);
    }

    public abstract void exibirInformacoesCliente();
}
