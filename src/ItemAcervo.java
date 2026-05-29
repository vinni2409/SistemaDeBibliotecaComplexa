import java.util.Random;

public class ItemAcervo {
    private int id;
    private String titulo;
    private String autor;
    private int anoDaPublicacao;
    private boolean disponivel;
    private Random random = new Random();

    public ItemAcervo(String titulo, String autor, int anoDaPublicacao) {
        this.id = random.nextInt(10000);
        this.titulo = titulo;
        this.autor = autor;
        this.anoDaPublicacao = anoDaPublicacao;
        this.disponivel = true;
    }

    public String getDetalhes() {
        return "ID: " + id + " | Titulo: " + titulo + " | Autor: " + autor +
                " | Ano: " + anoDaPublicacao + " | Disponivel: " + disponivel;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnoDaPublicacao() { return anoDaPublicacao; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}