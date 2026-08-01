import java.math.BigDecimal;
import java.math.RoundingMode;

public class CartaoCredito implements Pagavel, CobrarJuros {

    private BigDecimal limite;

    private int parcelas;

    public CartaoCredito(int parcelas) {
        this.limite = BigDecimal.valueOf(1000);
        this.parcelas = parcelas;
    }

    @Override
    public void pagar(BigDecimal valor) throws LimiteExcedidoException {
        if (valor.compareTo(this.limite) > 0) {
            throw new LimiteExcedidoException("Você não pode pagar o valor acima do limite " + limite);
        }

        System.out.println("Valor sem juros: " + valor.toString());

        BigDecimal acrescimoJuros = calcularJuros(valor).multiply(BigDecimal.valueOf(parcelas));
        valor = valor.add(acrescimoJuros);

        System.out.println("Pagamento de " + valor + " feito com sucesso no cartão de crédito em " + parcelas + " parcela(s)!");

        var valorPorParcela = valor.divide(BigDecimal.valueOf(parcelas), 2, RoundingMode.DOWN);
        System.out.println("Valor por parcela: " + valorPorParcela.toString());
    }

    @Override
    public BigDecimal calcularJuros(BigDecimal valor) {
        var umPorCento = BigDecimal.ONE.divide(BigDecimal.valueOf(100));
        return valor.multiply(umPorCento);
    }

    private class LimiteExcedidoException extends Exception {

        public LimiteExcedidoException(String message) {
            super(message);
        }
    }

}
