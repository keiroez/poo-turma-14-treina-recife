
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Boleto boleto = new Boleto();
        // boleto.pagar(BigDecimal.TEN);

        try {
            CartaoCredito cartaoCredito = new CartaoCredito(12);
            cartaoCredito.pagar(BigDecimal.valueOf(500));
        } catch (Exception e) {
            System.out.println("Envie email para o comprador");
        }

        // Diferença double e bigdecimal
        // double valor = 245 / 456;
        // System.out.println(valor);

        // BigDecimal valor1 = BigDecimal.valueOf(245).divide(BigDecimal.valueOf(456),
        // 10, RoundingMode.DOWN);
        // System.out.println(valor1.toString());


        //Lista de Interfaces
        List<Pagavel> lista = new ArrayList<>();
        for (Pagavel p : lista) {
            p.pagar(BigDecimal.TEN);
        }

    }
}
