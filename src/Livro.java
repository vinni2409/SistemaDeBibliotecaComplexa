public class Livro extends ItemAcervo{
    private String isbn;
    private int numeroPaginas;
    private String genero;

    public Livro( String titulo, String autor, int anoDaPublicacao, String isbn, int numeroPaginas, String genero) {
        super(titulo, autor, anoDaPublicacao);
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
    }

    public String getDetalhes(){
        return "ISBN: " + isbn + " | Numero de paginas: " + numeroPaginas + " | genero: " + genero;
    }

}
