
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) throws Exception {
        Gerente gerente = new Gerente(
                "Izaquiel",
                BigDecimal.valueOf(100.5),
                10);
        gerente.exibir();
        gerente.calcularFGTS();

        System.out.println("___________________________________________");

        Atendente atendente = new Atendente(
            "Jose", 
            BigDecimal.valueOf(100), 
            BigDecimal.TEN
        );
        atendente.exibir();
        atendente.calcularFGTS();

        System.out.println("___________________________________________");

        var atendente2 = new Atendente("Katia", BigDecimal.TEN, BigDecimal.TEN);
        atendente2.exibir();
        atendente2.calcularFGTS();
    }
}
