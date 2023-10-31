import java.time.LocalDate;

class ContaPoupanca extends Conta {
    
    LocalDate data = LocalDate.now();

    public ContaPoupanca(){

        
    }

    public ContaPoupanca(Cliente cliente, String numeroConta, Double saldo){
        super(cliente, numeroConta, saldo);
    }

    public void rendimento(){

        if(data.getDayOfMonth() == 5){
            Double saldoTotal = getSaldo();
            Double rendimento;
            rendimento = (saldoTotal*(0.5))/100.0;
            saldoTotal += rendimento;
            setSaldo(saldoTotal);
            
            System.out.printf("Seu rendimento foi de R$" + "%.2f%n", rendimento);
        }
    }
}
