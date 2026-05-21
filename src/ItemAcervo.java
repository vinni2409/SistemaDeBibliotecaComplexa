public class ItemAcervo {
    private int Id;
    private String Titulo;
    private String Autor;
    private int AnoDaPublicacao;
    private boolean Disponivel;

    public String getDetalhes(){
        return "ID: " + Id + " | Título: " + Titulo + " | Autor: " + Autor + " | Ano: " + AnoDaPublicacao + " | Disponivel" + Disponivel;
    }


}
