public class MidiaDigital extends ItemAcervo{
    private String formato;
    private String urlAcesso;
    private double tamanhoMB;

    public MidiaDigital(int id, String titulo, String autor, int anoDaPublicacao, boolean disponivel, String formato, String urlAcesso, double tamanhoMB) {
        super(id, titulo, autor, anoDaPublicacao, disponivel);
        this.formato = formato;
        this.urlAcesso = urlAcesso;
        this.tamanhoMB = tamanhoMB;
    }

    public String getDetalhes(){
        return "Formato: " + formato + " | Url de acesso: " + urlAcesso + " | Tamanho do arquivo: " + tamanhoMB;
    }
}
