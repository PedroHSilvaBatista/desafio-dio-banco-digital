package br.com.dio.models.clientes;

import java.util.Arrays;

enum UnidadesFederativas {
    ACRE("Acre", "AC", 12),
    ALAGOAS("Alagoas", "AL", 27),
    AMAPA("Amapá", "AP", 16),
    AMAZONAS("Amazonas", "AM", 13),
    BAHIA("Bahia", "BA", 29),
    CEARA("Ceará", "CE", 23),
    DISTRITO_FEDERAL("Distrito Federal", "DF", 53),
    ESPIRITO_SANTO("Espírito Santo", "ES", 32),
    GOIAS("Goiás", "GO", 52),
    MARANHAO("Maranhão", "MA", 21),
    MATO_GROSSO("Mato Grosso", "MT", 51),
    MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS", 50),
    MINAS_GERAIS("Minas Gerais", "MG", 31),
    PARA("Pará", "PA", 15),
    PARAIBA("Paraíba", "PB", 25),
    PARANA("Paraná", "PR", 41),
    PERNAMBUCO("Pernambuco", "PE", 26),
    PIAUI("Piauí", "PI", 22),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ", 33),
    RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN", 24),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS", 43),
    RONDONIA("Rondônia", "RO", 11),
    RORAIMA("Roraima", "RR", 14),
    SANTA_CATARINA("Santa Catarina", "SC", 42),
    SAO_PAULO("São Paulo", "SP", 35),
    SERGIPE("Sergipe", "SE", 28),
    TOCANTINS("Tocantins", "TO", 17);


    private final String nome;
    private final String sigla;
    private final int codigoIBGE;

    UnidadesFederativas(String nome, String sigla, int codigoIBGE) {
        this.nome = nome;
        this.sigla = sigla;
        this.codigoIBGE = codigoIBGE;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public static UnidadesFederativas encontrarUFPorSigla(String siglaDeBusca) {
        return Arrays.stream(values()).filter(uf -> uf.getSigla().equalsIgnoreCase(siglaDeBusca))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Sigla inválida: " + siglaDeBusca));
    }

    @Override
    public String toString() {
        return "UF: " + nome + ", Sigla: " + sigla + ", Código IBGE: " + codigoIBGE;
    }
}
