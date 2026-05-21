public class Livro extends ItemAcervo{
    private String isbn;
    private int numeroPaginas;
    private String genero;

    public Livro(int id, String titulo, String autor, int anoDaPublicacao, boolean disponivel, String isbn, int numeroPaginas, String genero) {
        super(id, titulo, autor, anoDaPublicacao, disponivel);
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.genero = genero;
    }
}
