public class Livro {
    String titulo;
    String autor;
    int paginas;

    public Livro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public void resumo() {
        System.out.println(titulo + " - " + autor);
        this.contarPaginas();
    }

    public void contarPaginas() {
        System.out.println("Numero de paginas: " + paginas);
    }

}
