import java.math.BigDecimal;

public class ContaCorrente extends Conta {
    private int taxaManutencao;

    public ContaCorrente(Cliente cliente, int numero, int agencia, BigDecimal saldo) {
        super(cliente, numero, agencia, saldo);
        this.taxaManutencao = 35;
    }

    public void cobrarManutencao() {
        var taxa = BigDecimal.valueOf(taxaManutencao);
        this.sacar(taxa);
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

    public int getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(int taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }

}
