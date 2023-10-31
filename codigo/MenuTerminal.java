import java.util.Scanner;


public class MenuTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String opcao;
        Investimento investimento = new Investimento();
        ContaCorrente contaCorrente = new ContaCorrente();
        ContaPoupanca poupanca = new ContaPoupanca();
        RendaFixa rendaFixa = new RendaFixa();
        
        

        do {
            System.out.println("=== Menu do XuBank ===");
            System.out.println("1. === Consulta de saldo ===");
            System.out.println("2. === Depósito ===");
            System.out.println("3. === Saque ===");
            System.out.println("4. === Transferências ===");
            System.out.println("5. === Adicionar cliente ===");
            System.out.println("6. === Adicionar ClienteGOLD ===");
            System.out.println("7. === Adicionar ClienteVIP ===");
            System.out.println("8. === Calcular Rendimento Diario ===");
            System.out.println("9. === Fazer saque especial da conta corrente ===");
            System.out.println("10. === Verificar Rendimento Poupanca ===");
            System.out.println("11. === Calcular Rendimento Renda Fixa ===");
            System.out.println("12. === Realizar Saque Renda Fixa ===");
            System.out.println("13. === Acesso Diretoria ===");
            
            
            
            
            System.out.println("13. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                	System.out.println("Voce possui R$" + investimento.getSaldo() + " em sua conta");
                	break;
                case "2":
                	investimento.deposito();
                    break;
                case "3":
                	investimento.saque();
                    break;
                case "4":
                	investimento.transferencia(investimento);
                    break;
                case "5":
                	System.out.println("---- SISTEMA DE CRIAÇÃO DE CONTA REGULAR ----");
                	System.out.println("---- Qual nome do usuario ----");
                	String nome = scanner.nextLine();
                	System.out.println("---- Qual o CPF do usuario----");
                	String cpf = scanner.nextLine();
                	System.out.println("---- Qual a Senha do usuario----");
                	String senha = scanner.nextLine();
                	Cliente cliente = new ClienteRegular(nome, cpf, senha);
                	
                	cliente.adicionarConta(investimento);
                	System.out.println("Usuario adicionado com exito!");
                    break;
                case "6":
                	System.out.println("---- SISTEMA DE CRIAÇÃO DE CONTA GOLD ----");
                	System.out.println("---- Qual nome do usuario ----");
                	nome = scanner.nextLine();
                	System.out.println("---- Qual o CPF do usuario----");
                	cpf = scanner.nextLine();
                	System.out.println("---- Qual a Senha do usuario----");
                	senha = scanner.nextLine();
                	Cliente clienteGold = new ClienteGold(nome, cpf, senha);
                	
                	clienteGold.adicionarConta(investimento);
                	System.out.println("Usuario adicionado com exito!");
                	break;
                case "7":
                	System.out.println("---- SISTEMA DE CRIAÇÃO DE CONTA VIP ----");
                	System.out.println("---- Qual nome do usuario ----");
                	nome = scanner.nextLine();
                	System.out.println("---- Qual o CPF do usuario----");
                	cpf = scanner.nextLine();
                	System.out.println("---- Qual a Senha do usuario----");
                	senha = scanner.nextLine();
                	Cliente clienteVIP = new ClienteVip(nome, cpf, senha);
                	
                	clienteVIP.adicionarConta(contaCorrente);
                	System.out.println("Usuario adicionado com exito!");
                	break;
                case "8":
                	System.out.println("Calculando investimento...");
                	investimento.calcularRendimentoDiario();
                    break;
                case "9":
                	contaCorrente.saqueEspecial();
                    break;
                case "10":
                	poupanca.rendimento();
                    break;
                case "11":
                	rendaFixa.calcularRendimento();
                    break;
                case "12":
                	rendaFixa.saque();
                    break;
                case "13":
                	break;
                    ''
                    
                case "14":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (!opcao.equals("14"));

        scanner.close();
    }
}