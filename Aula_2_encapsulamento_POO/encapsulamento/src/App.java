public class App {
    public static void main(String[] args) throws Exception {
        LivroEncapsulado livro = new LivroEncapsulado(
            "POO Encapsulamento", 
            "izaqulel", 
            2026, 
            100
        );
        // livro.setPaginas(-500);
        // System.out.println(livro.getPaginas());


        livro.setAno(1000);

    }
}
