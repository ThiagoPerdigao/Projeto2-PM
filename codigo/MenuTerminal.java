import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static MenuTerminal menuTerminal = new MenuTerminal();

    public static void main(String[] args) {
        String opcao;

        do {
            System.out.println("\n=== Menu do XuBank ===");
            System.out.println("a. Listar todos os clientes");
            System.out.println("b. Verificar o saldo de um cliente específico");
            System.out.println("c. Listar todas as contas e seus saldos");
            System.out.println("d. Ver os detalhes de uma conta específica");
            System.out.println("x. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "a":
                    menuTerminal.listarClientes();
                    break;
                case "b":
                    System.out.print("Informe o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    menuTerminal.verificarSaldoCliente(cpfCliente);
                    break;
                case "c":
                    menuTerminal.listarContas();
                    break;
                case "d":
                    System.out.print("Informe o número da conta: ");
                    int numeroConta = scanner.nextInt();
                    scanner.nextLine(); 
                    menuTerminal.verDetalhesConta(numeroConta);
                    break;
                case "x":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (!opcao.equals("x"));

        scanner.close();
    }
}

class MenuTerminal {
    private static List<Cliente> clientes = new ArrayList<>();

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }

    public void verificarSaldoCliente(String cpf) {
        Cliente cliente = buscarClientePorCPF(cpf);
        if (cliente != null) {
            System.out.println("Saldo do cliente " + cliente.getNome() + ": " + cliente.getConta().getSaldo());
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public void listarContas() {
        for (Cliente cliente : clientes) {
            Conta conta = cliente.getConta();
            System.out.println("Conta número: " + conta.getNumero() + ", Saldo: " + conta.getSaldo());
        }
    }

    public void verDetalhesConta(int numeroConta) {
        Conta conta = buscarContaPorNumero(numeroConta);
        if (conta != null) {
            System.out.println(conta.toString());
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    
}