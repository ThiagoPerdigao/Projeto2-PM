import java.util.Random;
import java.util.Scanner;

class Investimento extends Conta {
    private double rendimentoDiario;
    private double imposto;
    private double taxa;

    public Investimento(){

    }

    public Investimento(Cliente cliente, String numeroConta, double saldo, double rendimentoDiario, double imposto, double taxa) {
        super(cliente, numeroConta, saldo);
        this.rendimentoDiario = rendimentoDiario;
        this.imposto = imposto;
        this.taxa = taxa;
    }

    public double getRendimentoDiario() {
        return rendimentoDiario;
    }

    public void setRendimentoDiario(double rendimentoDiario) {
        this.rendimentoDiario = rendimentoDiario;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public void calcularRendimentoDiario() {
    // Gere um valor de rendimento diário aleatório entre -1% e +1%
    double rendimentoDiario = -1 + (new Random().nextDouble() * (1 - (-1)));
    
    double saldoAtual = getSaldo();
    double rendimento = saldoAtual * (rendimentoDiario / 100.0);
    saldoAtual += rendimento;
    setSaldo(saldoAtual);
}

    @Override
    public void saque() {
        double saldoAtual = getSaldo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor que deseja sacar:");
        double valorSaque = sc.nextDouble();
        if (valorSaque <= saldoAtual) {
            // Calcula o rendimento antes do saque
            double rendimento = saldoAtual * (rendimentoDiario / 100.0);
            // Aplica o imposto de 15% sobre o rendimento
            double impostoSobreRendimento = rendimento * 0.15;
            // Atualiza o saldo considerando o rendimento e o imposto
            saldoAtual += rendimento - impostoSobreRendimento;
            // Realiza o saque
            saldoAtual -= valorSaque;
            setSaldo(saldoAtual);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void deposito() {
        double saldoAtual = getSaldo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor que deseja depositar:");
        double valorDeposito = sc.nextDouble();
        // Calcula a taxa de depósito
        double taxaDeposito = valorDeposito * (taxa / 100.0);
        // Aplica o valor do depósito ao saldo e subtrai a taxa de depósito
        saldoAtual += valorDeposito - taxaDeposito;
        setSaldo(saldoAtual);
    }
}
