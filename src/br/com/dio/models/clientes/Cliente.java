package br.com.dio.models.clientes;


public sealed abstract class Cliente permits ClienteComum, ClienteVIP {
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

    protected void exibirInfosComuns() {
        System.out.println("Nome do titular: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Estado pertencente: " + unidadeFederativa.getNome() + "-"
                + unidadeFederativa.getSigla());
    }

    protected abstract void exibirInformacoesCliente();
}
