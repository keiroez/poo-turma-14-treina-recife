public class LivroEncapsulado {

    private String titulo;
    private String autor;
    private int ano;
    private int paginas;


    public LivroEncapsulado(String titulo, String autor, int ano, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.paginas = paginas;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String tituloNovoP) {
        this.titulo = tituloNovoP;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autorNovo) {
        this.autor = autorNovo;
    }


    public int getAno() {
        return ano;
    }


    public void setAno(int anoNovo) {
        if(anoNovo < 1885){
            System.out.println("Ano anterior a 1885");
            return;
        }

        this.ano = anoNovo;
    }


    public int getPaginas() {
        return paginas;
    }


    public void setPaginas(int paginas) {
        if(paginas<2){
           System.out.println("No de paginas inválido");
           return;
        } 

        this.paginas = paginas;
    }
    
    

}
