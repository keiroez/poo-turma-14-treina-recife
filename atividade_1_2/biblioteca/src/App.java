public class App {
    public static void main(String[] args) throws Exception {
        Livro novoLivro = new Livro(
            "POO",
            "Izaquiel",
            "1342142141",
            2025
        );

        Emprestimo novoEmprestimo = new Emprestimo(novoLivro, "Joao", 10);

        System.out.println(novoEmprestimo.resumo());


        Livro novoLivroSpring = new Livro(
            "Spring Boot",
            "Izaquiel",
            "1342142141",
            2026
        );

        Emprestimo novoEmprestimo2 = new Emprestimo(novoLivroSpring, "Maria", 10);

        System.out.println(novoEmprestimo2.resumo());

        novoEmprestimo.devolver();

        Emprestimo novoEmprestimo3 = new Emprestimo(novoLivro, "Maria", 10);

        System.out.println(novoEmprestimo3.resumo());


        Livro novoLivroMySQL = new Livro(
            "MySQL",
            "Izaquiel",
            "1342142141",
            2026
        );

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro(novoLivro);
        biblioteca.adicionarLivro(novoLivroSpring);
        biblioteca.adicionarLivro(novoLivroMySQL);

        novoEmprestimo2.devolver();

        biblioteca.listarDisponiveis();

        Livro livroPOO = biblioteca.buscarPorTitulo("POO");
        System.out.println("Livro encontrado "+livroPOO.getTitulo());


        //Um objeto é o mesmo sempre
        Livro livroExemplo = livroPOO;
    }
}
