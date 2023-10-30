import java.util.Scanner;

abstract class Conta {
    protected Cliente cliente;
    protected String numeroConta;
    protected Double saldo = 0.0;

    public Conta(){
    }

    public Conta(Cliente cliente, String numeroConta, Double saldo){
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String getNumeroConta(){
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta){
        this.numeroConta = numeroConta;
    }

    public Double getSaldo(){
        return saldo;
    }

    public void setSaldo(Double saldo){
        this.saldo = saldo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public void deposito(){
        Double valorDeposito;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor que deseja depositar:");
        valorDeposito = sc.nextDouble();
        saldo = getSaldo();
        setSaldo(saldo+valorDeposito);
        System.out.println("Valor depositado: " + valorDeposito);
    }

    public void saque(){
        Double valorSaque;
        
        Scanner sc = new Scanner(System.in);
          
        System.out.println("Digite o valor que deseja sacar:");
        valorSaque = sc.nextDouble();
        saldo = getSaldo();
        if(valorSaque <= saldo){
            setSaldo(saldo-valorSaque);
            System.out.println("Valor sacado com sucesso!. Agora voce possui R$" + consultarSaldo() + "Em sua conta bancaria");
        }
        else{
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transferencia(Conta contaDestino){
        String numeroContaDestino;
        Double valorTransferencia, saldoContaDestino;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o numero da conta que deseja transferir:");
        numeroContaDestino = sc.nextLine();
        System.out.println("Digite o valor da transferencia:");
        valorTransferencia = sc.nextDouble();

        if(numeroContaDestino.equals(contaDestino.getNumeroConta())){
            saldoContaDestino = contaDestino.getSaldo();
            contaDestino.setSaldo(saldoContaDestino+valorTransferencia);
        }
        else{
            System.out.println("Conta não encontrada.");
        }

        
    }
    
    public double consultarSaldo() {
    	return getSaldo();
    }
    
    
    
    
}
