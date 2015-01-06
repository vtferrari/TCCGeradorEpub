package tcc.vinicius.html.busca.tag.simbolo;

public class TagAtributada implements BuscaTagSPL {

    private String de;
    private String para;

    public TagAtributada(String de, String para) {
        this.de = de;
        this.para = para;
    }

    @Override
    public String converteParaHTML(String html) {
        return html.replace("[", "<")
                   .replace("]", " />")
                   .replace(de, para);
    }
}
