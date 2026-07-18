
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) throws Exception {
        Cliente cliente = new Cliente(
                "Jose",
                "123456789",
                "jose@jose.com",
                "12345678");


        Conta conta = new Conta(
            cliente,
            1,
            1,
            BigDecimal.valueOf(1000)
        );

        //Jose quer sacar 500 reais
        conta.sacar(BigDecimal.valueOf(500));

        //Jose quer ver o saldo atual
        conta.extrato();

        //Jose quer depositar 2000
        conta.depositar(BigDecimal.valueOf(2000));

        //Jose quer ver o saldo atual
        conta.extrato();

    }
}
