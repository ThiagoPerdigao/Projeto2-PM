class ClienteVip extends Cliente {

    private int pontosFidelidade;
    private static final int MENSALIDADE = 30;
    private static final int PONTOS_MENSALIDADE = 35;
    private static final int PONTOS_POR_DOIS_MIL_REAIS = 30;

    public ClienteVip(){
    }

    public ClienteVip(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        this.pontosFidelidade = 0;
    }

    public void acumularPontosFidelidade() {
        this.pontosFidelidade += PONTOS_MENSALIDADE;

        for (Conta conta : contas) {
            this.pontosFidelidade += (int) (conta.getSaldo() / 2000) * PONTOS_POR_DOIS_MIL_REAIS;
        }
    }

    public int getPontosFidelidade() {
        return pontosFidelidade;
    }
}