public class ItemAcervo {
    private int id;
    private String titulo;
    private String autor;
    private int anoDaPublicacao;
    private boolean disponivel;

    public ItemAcervo(int id, String titulo, String autor, int anoDaPublicacao, boolean disponivel) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoDaPublicacao = anoDaPublicacao;
        this.disponivel = true;
    }

    public String getDetalhes(){
        return "ID: " + id + " | Título: " + titulo + " | Autor: " + autor + " | Ano: " + anoDaPublicacao + " | Disponivel" + disponivel;
    }
}
