import java.util.HashMap;
import java.util.Scanner;

interface Operacao {
    double consultarSaldo();
    void depositar(double valor);
    boolean sacar(double valor);
    boolean transferir(Conta destino, double valor);
}

abstract class Conta implements Operacao {
    

    @Override
    public double consultarSaldo() {
        return this.saldo;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.depositar(valor);
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }
}

public class BankMenu {

    private static HashMap<String, Conta> contas = new HashMap<>();
    private static HashMap<String, Cliente> clientes = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.println("\n=== Menu do Banco ===");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Criar Conta");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Depositar em Conta");
            System.out.println("5. Sacar de Conta");
            System.out.println("6. Transferir Entre Contas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    criarCliente();
                    break;
                case 2:
                    criarConta();
                    break;
                case 3:
                    consultarSaldo();
                    break;
                case 4:
                    depositar();
                    break;
                case 5:
                    sacar();
                    break;
                case 6:
                    transferir();
                    break;
                case 7:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 7);
    }

    private static void criarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf);
        clientes.put(cpf, cliente);
        System.out.println("Cliente criado com sucesso!");
    }

    private static void criarConta() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            System.out.println("1. Conta Corrente");
            System.out.println("2. Conta Poupança");
            System.out.println("3. Renda Fixa");
            int tipoConta = scanner.nextInt();

            System.out.println("Digite o número da conta: ");
            String numeroConta = scanner.next();

            System.out.println("Digite o saldo inicial: ");
            double saldoInicial = scanner.nextDouble();

            Conta conta = null;
            switch (tipoConta) {
                case 1:
                    conta = new ContaCorrente(cliente, numeroConta, saldoInicial);
                    break;
                case 2:
                    conta = new ContaPoupanca(cliente, numeroConta, saldoInicial);
                    break;
                case 3:
                    System.out.println("Digite a taxa de rendimento:");
                    double taxaRendimento = scanner.nextDouble();
                    conta = new RendaFixa(cliente, numeroConta, saldoInicial, taxaRendimento);
                    break;
            }

            if (conta != null) {
                contas.put(numeroConta, conta);
                System.out.println("Conta criada com sucesso!");
            }
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
