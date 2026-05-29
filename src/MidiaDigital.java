public class MidiaDigital extends ItemAcervo{
    private String formato;
    private String urlAcesso;
    private double tamanhoMB;

    public MidiaDigital(String titulo, String autor, int anoDaPublicacao, String formato, String urlAcesso, double tamanhoMB) {
        super(titulo, autor, anoDaPublicacao);
        this.formato = formato;
        this.urlAcesso = urlAcesso;
        this.tamanhoMB = tamanhoMB;
    }

    public String getDetalhes(){
        return "Formato: " + formato + " | Url de acesso: " + urlAcesso + " | Tamanho do arquivo: " + tamanhoMB;
    }
}
