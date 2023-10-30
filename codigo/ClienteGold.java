class ClienteGold extends Cliente {

    private int pontosFidelidade;
    private static final int TAXA_MENSAL = 10;
    private static final int PONTOS_MENSALIDADE = 10;
    private static final int PONTOS_POR_MIL_REAIS = 10;

    public ClienteGold(){
    }

    public ClienteGold(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        this.pontosFidelidade = 0;
    }

    public void acumularPontosFidelidade() {
        this.pontosFidelidade += PONTOS_MENSALIDADE;

        for (Conta conta : contas) {
            this.pontosFidelidade += (int) (conta.getSaldo() / 1000) * PONTOS_POR_MIL_REAIS;
        }
    }

    public int getPontosFidelidade() {
        return pontosFidelidade;
    }

}