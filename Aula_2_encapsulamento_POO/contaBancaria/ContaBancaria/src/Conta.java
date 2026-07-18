
import java.math.BigDecimal;

public class Conta {
    private Cliente cliente;
    private int numeroConta;
    private int numeroAgencia;

    /**
     * No CompareTo do BigDecimal o comparativo segue a regra
     * == 0 equivale a um numero é igual a outro?
     * == 1 equivale a um numero é maior que outro?
     * == -1 equivale a um numero é menor que outro?
     */
    private BigDecimal saldo;

    public void sacar(BigDecimal valorSaque) {
        // Saldo é maior que zero?
        if (saldo.compareTo(BigDecimal.ZERO) == 1) {
            // Saldo é maior que valor do saque?
            if (saldo.compareTo(valorSaque) == 1) {
                // Equivale a saldo = saldo - valorSaque
                System.out.println("Saque de "+valorSaque);
                saldo = saldo.subtract(valorSaque);
            }
        }
    }

    public void depositar(BigDecimal valorDeposito) {
        // Equivale a saldo = saldo + valorDeposito;
        System.out.println("Deposito de "+valorDeposito);
        saldo = saldo.add(valorDeposito);
    }

    public void extrato() {
        System.out.println("Valor Do Saldo: " + saldo);
    }

    public Conta(Cliente cliente, int numeroConta, int numeroAgencia, BigDecimal saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

}
