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

    

}

public static void main(String[] args) {
    MenuTerminal.iniciar();
}