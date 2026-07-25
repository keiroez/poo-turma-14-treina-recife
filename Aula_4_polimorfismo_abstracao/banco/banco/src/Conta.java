
import java.math.BigDecimal;

public abstract class Conta {
    private Cliente cliente;
    private int numero;
    private int agencia;
    private BigDecimal saldo;

    public Conta(Cliente cliente, int numero, int agencia, BigDecimal saldo) {
        this.cliente = cliente;
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    // Sera implentado na classe filha
    public abstract void sacar(BigDecimal valor);

    // Sera implentado na classe filha
    public abstract void depositar(BigDecimal valor);

    // Nao pode ser sobreescrito pela classe filha
    public final void imprimirExtrato() {
        System.out.println("SALDO ATUAL: " + saldo);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    protected void setSaldo(BigDecimal valor) {
        System.out.println("Saldo alterado de " + this.saldo + " para " + valor + " da conta de " + cliente.getNome());
        this.saldo = valor;
    }

}
