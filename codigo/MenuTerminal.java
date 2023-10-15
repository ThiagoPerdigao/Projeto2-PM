
private static List<Cliente> clientes = new ArrayList<>();
private static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
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

private static void cadastrarCliente() {
    System.out.println("\n==== Cadastro de Cliente ====");

    System.out.print("Nome: ");
    String nome = sc.next();

    System.out.print("CPF: ");
    String cpf = sc.next();

    System.out.print("Senha: ");
    String senha = sc.next();

    System.out.print("Tipo de cliente (Regular/Vip/Gold): ");
    String tipo = sc.next();

    Cliente cliente;
    switch (tipo.toLowerCase()) {
        case "vip":
            cliente = new ClienteVip(nome, cpf, senha);
            break;
        case "gold":
            cliente = new ClienteGold(nome, cpf, senha);
            break;
        default:
            cliente = new ClienteRegular(nome, cpf, senha);
            break;
    }

    clientes.add(cliente);
    System.out.println("Cliente cadastrado com sucesso!");
}

private static void abrirConta() {
    System.out.println("\n==== Abertura de Conta ====");

    System.out.print("CPF do cliente: ");
    String cpf = sc.next();
    
    Cliente cliente = buscarClientePorCPF(cpf);
    if(cliente == null) {
        System.out.println("Cliente não encontrado!");
        return;
    }

    System.out.print("Tipo de conta (Corrente/Poupança/Investimento/RendaFixa): ");
    String tipo = sc.next();

    System.out.print("Número da conta: ");
    String numero = sc.next();

    System.out.print("Saldo inicial: ");
    double saldo = sc.nextDouble();

    Conta conta;
    switch (tipo.toLowerCase()) {
        case "corrente":
            conta = new ContaCorrente(cliente, numero, saldo);
            break;
        case "poupanca":
            conta = new ContaPoupanca(cliente, numero, saldo);
            break;
        case "investimento":
            System.out.print("Rendimento diário (%): ");
            double rendimentoDiario = sc.nextDouble();
            System.out.print("Taxa de imposto (%): ");
            double imposto = sc.nextDouble();
            System.out.print("Taxa de depósito (%): ");
            double taxa = sc.nextDouble();
            conta = new Investimento(cliente, numero, saldo, rendimentoDiario, imposto, taxa);
            break;
        case "rendafixa":
            System.out.print("Taxa de rendimento (%): ");
            double taxaRendimento = sc.nextDouble();
            conta = new RendaFixa(cliente, numero, saldo, taxaRendimento);
            break;
        default:
            System.out.println("Tipo de conta inválido!");
            return;
    }

    cliente.adicionarConta(conta);
    System.out.println("Conta criada com sucesso!");
}

private static void depositarConta() {
    System.out.println("\n==== Depósito em Conta ====");

    System.out.print("Número da conta: ");
    String numero = sc.next();

    Conta conta = buscarContaPorNumero(numero);
    if(conta == null) {
        System.out.println("Conta não encontrada!");
        return;
    }

    System.out.print("Valor do depósito: ");
    double valor = sc.nextDouble();

    conta.deposito(valor);
    System.out.println("Depósito realizado com sucesso!");
}

private static void sacarConta() {
    System.out.println("\n==== Saque em Conta ====");

    System.out.print("Número da conta: ");
    String numero = sc.next();

    Conta conta = buscarContaPorNumero(numero);
    if(conta == null) {
        System.out.println("Conta não encontrada!");
        return;
    }

    System.out.print("Valor do saque: ");
    double valor = sc.nextDouble();

    conta.saque(valor);
    System.out.println("Saque realizado com sucesso!");
}

private static void visaoDiretoria() {
    System.out.println("\n==== Visão da Diretoria ====");
    System.out.println("Total em custódia em Contas Correntes: " + VisaoDiretoria.calcularTotalCustodiaContaCorrente(clientes));
    System.out.println("Total em custódia em Contas Poupança: " + VisaoDiretoria.calcularTotalCustodiaContaPoupanca(clientes));
    System.out.println("Saldo médio de todas as contas: " + VisaoDiretoria.calcularSaldoMedio(clientes));
}

private static Cliente buscarClientePorCPF(String cpf) {
    for(Cliente cliente : clientes) {
        if(cliente.getCpf().equals(cpf)) {
            return cliente;
        }
    }
    return null;
}

private static Conta buscarContaPorNumero(String numero) {
    for(Cliente cliente : clientes) {
        for(Conta conta : cliente.getContas()) {
            if(conta.getNumero().equals(numero)) {
                return conta;
            }
        }
    }
    return null;
}
}