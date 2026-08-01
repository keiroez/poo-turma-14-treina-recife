import java.math.BigDecimal;

public class Boleto implements Pagavel {

    @Override
    public void pagar(BigDecimal valor) {
        System.out.println("Pagamento de "+valor+" feito com sucesso no boleto!");
        
    }

}
