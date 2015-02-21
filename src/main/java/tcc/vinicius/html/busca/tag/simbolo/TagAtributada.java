package tcc.vinicius.html.busca.tag.simbolo;

public class TagAtributada implements BuscaTagSPL {

    private final String de;
    private final String para;

    public TagAtributada(String de, String para) {
        this.de = de;
        this.para = para;
    }

    @Override
    public String converteParaHTML(String html) {
        return html.replaceAll("\\["+de+"(.*)\\]","<"+ para+"$1 />");
    }
}
