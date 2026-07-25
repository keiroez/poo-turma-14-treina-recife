import java.math.BigDecimal;

public class ContaPoupanca extends Conta {
    private int taxaRendimento;

    public ContaPoupanca(Cliente cliente, int numero, int agencia, BigDecimal saldo) {
        super(cliente, numero, agencia, saldo);
        this.taxaRendimento = 1;
    }

    @Override
    public void depositar(BigDecimal valor) {
        var novoValor = this.getSaldo().add(valor);
        super.setSaldo(novoValor);
    }

    @Override
    public void sacar(BigDecimal valor) {
        if (valor.compareTo(this.getSaldo()) > 0) {
            throw new RuntimeException("Voce nao tem saldo suficiente");
        }
        var novoValor = this.getSaldo().subtract(valor);
        super.setSaldo(novoValor);
    }

    public void render() {
        var percentual = taxaRendimento / 100;
        var rendimento = this.getSaldo().multiply(BigDecimal.valueOf(percentual));
        this.depositar(rendimento);
    }

    public void render(BigDecimal valorRendimento) {
        this.depositar(valorRendimento);
    }

    public int getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(int taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

}
