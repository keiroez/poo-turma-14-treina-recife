import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> listaLivros;

    public Biblioteca() {
        this.listaLivros = new ArrayList<>();
    }

    public Livro buscarPorTitulo(String titulo) throws Exception{
        for(Livro livro: listaLivros){
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                return livro;
            }
        }

        throw new Exception("Livro "+titulo+" não encontrado");
    }


    public void adicionarLivro(Livro livro){
        this.listaLivros.add(livro);
    }


    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public void listarDisponiveis(){
        for(Livro livro: listaLivros){
            if(livro.isDisponivel()){
                System.out.println(livro.getTitulo()+" disponivel");
            }
        }
    }
    
}
