public class App {
    public static void main(String[] args) throws Exception {
        Livro meuLivro = new Livro("Aula de POO", "Izaquiel", 100);
        System.out.println(meuLivro.titulo);

        
        meuLivro.resumo();
    }
}
