
import java.math.BigDecimal;

public class Atendente extends Funcionario {
    private BigDecimal comissao;

    public Atendente(String nome, BigDecimal salario, BigDecimal comissao) {
        super(nome, salario);
        this.comissao = comissao;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

}
