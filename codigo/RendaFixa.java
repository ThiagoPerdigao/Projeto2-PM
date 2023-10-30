import java.util.Scanner;

class RendaFixa extends Conta {
    private double taxaRendimento; // Taxa de rendimento contratada no momento da criação

    public RendaFixa(){

    }

    public RendaFixa(Cliente cliente, String numeroConta, double saldo, double taxaRendimento) {
        super(cliente, numeroConta, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public void calcularRendimento() {
        double saldoAtual = getSaldo();
        double rendimentoAnual = saldoAtual * 0.05; // 5% ao ano
        double rendimentoDiario = rendimentoAnual / 365; // Assumindo 365 dias em um ano
        saldoAtual += rendimentoDiario;
        setSaldo(saldoAtual);
    }
    

    @Override
    public void saque() {
    Double valorSaque;
    Double saldo;
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o valor que deseja sacar:");
    valorSaque = sc.nextDouble();
    saldo = getSaldo();
    if (valorSaque <= saldo) {
        // Realiza o saque
        saldo -= valorSaque;
        
        // Calcula 15% de imposto sobre os rendimentos
        double rendimento = getSaldo() - saldo;
        double imposto = rendimento * 0.15;
        
        // Desconta o imposto dos rendimentos
        saldo -= imposto;

        // Atualiza o saldo
        setSaldo(saldo);
    } else {
        System.out.println("Saldo insuficiente.");
    }
}

}