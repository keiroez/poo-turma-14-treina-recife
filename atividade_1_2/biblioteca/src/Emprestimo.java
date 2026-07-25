public class Emprestimo {
    private Livro livro;
    private String nomeUsuario;
    private int diasEmprestimo;

    public Emprestimo(Livro livro, String nomeUsuario, int diasEmprestimo) {
        if(!livro.isDisponivel()){
            throw new IllegalArgumentException("Livro não está disponivel para emprestimo");
        }


        livro.setDisponivel(false);

        this.livro = livro;
        this.nomeUsuario = nomeUsuario;
        this.diasEmprestimo = diasEmprestimo;
    }

    public void devolver(){
        System.out.println(livro.getTitulo()+" devolvido por "+nomeUsuario);

        this.livro.setDisponivel(true);
    }

    public String resumo(){
        //"Dom Casmurro emprestado para Ana (7 dias)"
        return livro.getTitulo()+" emprestado para "+nomeUsuario+" ("+diasEmprestimo+" dias)";
    }
}
