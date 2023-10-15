import java.util.List;

public class VisaoDiretoria {

    // Método para calcular o total em custódia para cada tipo de conta
    public static double calcularTotalCustodiaContaCorrente(List<Cliente> clientes) {
        double totalCustodiaContaCorrente = 0.0;
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                if (conta instanceof ContaCorrente) {
                    totalCustodiaContaCorrente += conta.getSaldo();
                }
            }
        }
        return totalCustodiaContaCorrente;
    }

    public static double calcularTotalCustodiaContaPoupanca(List<Cliente> clientes) {
        double totalCustodiaContaPoupanca = 0.0;
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                if (conta instanceof ContaPoupanca) {
                    totalCustodiaContaPoupanca += conta.getSaldo();
                }
            }
        }
        return totalCustodiaContaPoupanca;
    }

    // Método para calcular o saldo médio de todas as contas
    public static double calcularSaldoMedioTodasContas(List<Cliente> clientes) {
        double saldoTotal = 0.0;
        int totalContas = 0;
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                saldoTotal += conta.getSaldo();
                totalContas++;
            }
        }
        return saldoTotal / totalContas;
    }

    // Método para contar o número de clientes com saldo total negativo
    public static int contarClientesComSaldoNegativo(List<Cliente> clientes) {
        int clientesComSaldoNegativo = 0;
        for (Cliente cliente : clientes) {
            double saldoTotalCliente = 0.0;
            for (Conta conta : cliente.getContas()) {
                saldoTotalCliente += conta.getSaldo();
            }
            if (saldoTotalCliente < 0) {
                clientesComSaldoNegativo++;
            }
        }
        return clientesComSaldoNegativo;
    }

    // Método para encontrar o cliente com o maior saldo total
    public static Cliente encontrarClienteComMaiorSaldo(List<Cliente> clientes) {
        Cliente clienteMaiorSaldo = null;
        double maiorSaldo = Double.MIN_VALUE;
        for (Cliente cliente : clientes) {
            double saldoTotalCliente = 0.0;
            for (Conta conta : cliente.getContas()) {
                saldoTotalCliente += conta.getSaldo();
            }
            if (saldoTotalCliente > maiorSaldo) {
                maiorSaldo = saldoTotalCliente;
                clienteMaiorSaldo = cliente;
            }
        }
        return clienteMaiorSaldo;
    }

    // Método para encontrar o cliente com o menor saldo total
    public static Cliente encontrarClienteComMenorSaldo(List<Cliente> clientes) {
        Cliente clienteMenorSaldo = null;
        double menorSaldo = Double.MAX_VALUE;
        for (Cliente cliente : clientes) {
            double saldoTotalCliente = 0.0;
            for (Conta conta : cliente.getContas()) {
                saldoTotalCliente += conta.getSaldo();
            }
            if (saldoTotalCliente < menorSaldo) {
                menorSaldo = saldoTotalCliente;
                clienteMenorSaldo = cliente;
            }
        }
        return clienteMenorSaldo;
    }
}
