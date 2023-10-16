import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String opcao;

        do {
            System.out.println("\n=== Menu do XuBank ===");
            System.out.println("a. Realizar operação");
            System.out.println("b. Investir em Renda Fixa");
            System.out.println("c. Ver visão da diretoria");
            System.out.println("d. Fazer investimento");
            System.out.println("e. Acessar conta poupança");
            System.out.println("f. Acessar conta corrente");
            System.out.println("g. Acessar conta");
            System.out.println("h. Cliente VIP");
            System.out.println("i. Cliente Regular");
            System.out.println("j. Cliente Gold");
            System.out.println("k. Acessar cliente");
            System.out.println("x. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "a":
                    Operacao operacao = new Operacao();
                    operacao.executar();
                    break;
                case "b":
                    RendaFixa rendaFixa = new RendaFixa();
                    rendaFixa.executar();
                    break;
                case "c":
                    VisaoDiretoria visaoDiretoria = new VisaoDiretoria();
                    visaoDiretoria.executar();
                    break;
                case "d":
                    Investimento investimento = new Investimento();
                    investimento.executar();
                    break;
                case "e":
                    ContaPoupanca contaPoupanca = new ContaPoupanca();
                    contaPoupanca.executar();
                    break;
                case "f":
                    ContaCorrente contaCorrente = new ContaCorrente();
                    contaCorrente.executar();
                    break;
                case "g":
                    Conta conta = new Conta();
                    conta.executar();
                    break;
                case "h":
                    ClienteVIP clienteVIP = new ClienteVIP();
                    clienteVIP.executar();
                    break;
                case "i":
                    ClienteRegular clienteRegular = new ClienteRegular();
                    clienteRegular.executar();
                    break;
                case "j":
                    ClienteGold clienteGold = new ClienteGold();
                    clienteGold.executar();
                    break;
                case "k":
                    Cliente cliente = new Cliente();
                    cliente.executar();
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