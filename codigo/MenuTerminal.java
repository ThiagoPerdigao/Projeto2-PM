import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuTerminal {

    private static List<Cliente> clientes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void iniciar() {
        int opcao;

        do {
            System.out.println("\n==== Menu do XuBank ====");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Abrir conta");
            System.out.println("3. Depositar em uma conta");
            System.out.println("4. Sacar de uma conta");
            System.out.println("5. Ver visão da diretoria");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();  

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    abrirConta();
                    break;
                case 3:
                    depositarConta();
                    break;
                case 4:
                    sacarConta();
                    break;
                case 5:
                    visaoDiretoria();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Cliente cliente = new Cliente(nome, cpf, senha);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static Cliente buscarClientePorCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    private static void abrirConta() {
        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();
        Cliente cliente = buscarClientePorCPF(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("Tipo de Conta (1-Corrente, 2-Poupanca): ");
        int tipo = sc.nextInt();
        sc.nextLine();

        Conta conta;

        switch (tipo) {
            case 1:
                conta = new ContaCorrente();
                break;
            case 2:
                conta = new ContaPoupanca();
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        cliente.addConta(conta);
        System.out.println("Conta criada com sucesso!");
    }

    private static void depositarConta() {
        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();
        Cliente cliente = buscarClientePorCPF(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("Informe o número da conta: ");
        int numeroConta = sc.nextInt();
        sc.nextLine();

        Conta conta = cliente.getContaByNumber(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.print("Valor a depositar: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        conta.depositar(valor);
        System.out.println("Depósito realizado com sucesso!");
    }

    private static void sacarConta() {
        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();
        Cliente cliente = buscarClientePorCPF(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("Informe o número da conta: ");
        int numeroConta = sc.nextInt();
        sc.nextLine();

        Conta conta = cliente.getContaByNumber(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.print("Valor a sacar: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        conta.sacar(valor);
        System.out.println("Saque realizado com sucesso!");
    }

    private static void visaoDiretoria() {
        
        System.out.println("=== Visão da Diretoria ===");
        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNome());
            for (Conta conta : cliente.getContas()) {
                System.out.println("Conta: " + conta.getNumero() + " - Saldo: " + conta.getSaldo());
            }
            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {
        MenuTerminal.iniciar();
    }
}