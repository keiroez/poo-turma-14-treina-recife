public class Quadrado extends FormaGeometrica {

    private int altura;
    private int largura;

    
    public Quadrado(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public void calcularArea() {
        var area = altura * largura;
        System.out.println("Area do quadrado: "+area);
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    

}
