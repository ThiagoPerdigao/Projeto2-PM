import java.time.LocalDate;
import java.util.Scanner;

class RendaFixa extends Conta {
    private double taxaRendimento; // Taxa de rendimento contratada no momento da criação

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
        // Implemente a lógica para calcular o rendimento com base na taxaRendimento
        double saldoAtual = getSaldo();
        double rendimento = saldoAtual * (taxaRendimento / 100.0);
        saldoAtual += rendimento;
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