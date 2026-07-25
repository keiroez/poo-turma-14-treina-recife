public class Circulo extends FormaGeometrica {

    private int raio;

    public Circulo(int raio) {
        this.raio = raio;
    }

    @Override
    public void calcularArea() {
        var area = raio*3.14;
        area = area * area;
        System.out.println("Area do circulo: "+area);
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    

}
