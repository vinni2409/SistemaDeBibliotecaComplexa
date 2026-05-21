public class RevistaAcademica extends ItemAcervo{
    private String issn;
    private String areaConhecimento;
    private int edicao;

    public RevistaAcademica(int id, String titulo, String autor, int anoDaPublicacao, boolean disponivel, String issn, String areaConhecimento, int edicao) {
        super(id, titulo, autor, anoDaPublicacao, disponivel);
        this.issn = issn;
        this.areaConhecimento = areaConhecimento;
        this.edicao = edicao;
    }

    public String getDetalhes(){
        return "ISSN: " + issn + " | Area de conhecimento: " + areaConhecimento + " | Edição: " + edicao;
    }
}
