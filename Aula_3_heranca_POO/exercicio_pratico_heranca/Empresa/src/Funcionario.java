import java.math.BigDecimal;

public class Funcionario {
    private  String nome;
    private BigDecimal salario;

    public Funcionario(String nome, BigDecimal salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public void exibir(){
        System.out.println(nome+" recebe "+salario+" por mês.");
    }

    public BigDecimal calcularFGTS(){
        var percentual = BigDecimal.valueOf(7.5);
        var valorFGTS = salario.multiply(percentual).divide(BigDecimal.valueOf(100));
        System.out.println("Valor do FGTS: "+valorFGTS);

        return valorFGTS;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    

}
