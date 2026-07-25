import java.math.BigDecimal;

public class Gerente extends Funcionario {

    private int bonus;

    public Gerente(String nome, BigDecimal salario, int bonus) {
        super(nome, salario);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

}
