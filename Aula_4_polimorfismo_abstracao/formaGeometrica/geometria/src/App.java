
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Quadrado quadrado = new Quadrado(10, 10);
        Circulo circulo = new Circulo(15);
        Triangulo triangulo = new Triangulo(10, 40);

        List<FormaGeometrica> formas = new ArrayList<>();

        formas.add(quadrado);
        formas.add(circulo);
        formas.add(triangulo);

        for(FormaGeometrica forma: formas){
            forma.calcularArea();
        }

    }
}
