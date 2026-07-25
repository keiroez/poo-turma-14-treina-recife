
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) throws Exception {
        Cliente cliente = new Cliente("Izaquiel", "12334", "izaquiel@izaquiel.com");

        ContaPoupanca poupanca = new ContaPoupanca(cliente, 123,123, BigDecimal.ZERO);
        ContaCorrente corrente = new ContaCorrente(cliente, 1234, 123, BigDecimal.ZERO);


        poupanca.depositar(BigDecimal.valueOf(1000));
        poupanca.sacar(BigDecimal.valueOf(230));

        poupanca.imprimirExtrato();

        corrente.depositar(BigDecimal.valueOf(300));

    }
}
