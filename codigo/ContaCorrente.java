import java.util.Scanner;

class ContaCorrente extends Conta {

    private Double taxaMensal = 20.0;

    
    public ContaCorrente(Cliente cliente, String numeroConta, Double saldo){
        super(cliente, numeroConta, saldo);
    }

    public void saqueEspecial(){
            Double valorSaque;
            Double saldo = 200.0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o valor que deseja sacar:");
            valorSaque = sc.nextDouble();
            saldo =+ getSaldo();
            if(valorSaque <= saldo){
                setSaldo(saldo-valorSaque);
            }
            else{
                System.out.println("Saldo insuficiente.");
            }
    }

}

