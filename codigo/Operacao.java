interface Operacao {

    double consultarSaldo();
    void depositar(double valor);
    boolean sacar(double valor);
    boolean transferir(Conta destino, double valor);
    
}