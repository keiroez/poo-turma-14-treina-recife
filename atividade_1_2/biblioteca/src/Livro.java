
import java.time.LocalDate;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private boolean disponivel;


    public Livro(String titulo, String autor, String isbn, int anoPublicacao) {

        LocalDate dataAtual = LocalDate.now();
        int anoAtual = dataAtual.getYear();

        if(anoPublicacao > anoAtual){
            throw new IllegalArgumentException("Ano não pode ser maior que ano atual");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        disponivel = true;
    }


    public String getTitulo() {
        return titulo;
    }


    public String getAutor() {
        return autor;
    }


    public String getIsbn() {
        return isbn;
    }


    public int getAnoPublicacao() {
        return anoPublicacao;
    }


    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    
}
