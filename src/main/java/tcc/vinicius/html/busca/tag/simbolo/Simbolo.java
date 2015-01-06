package tcc.vinicius.html.busca.tag.simbolo;

public class Simbolo implements BuscaTagSPL {

    private final String de;
    private final String para;

    public Simbolo(String de, String para) {
        this.de = de;
        this.para = para;
    }

    @Override
    public String converteParaHTML(String html) {
        return html.replaceAll( de+"([^"+de+"]+)"+de , "<"+para+">$1</"+para+">");
    }
}