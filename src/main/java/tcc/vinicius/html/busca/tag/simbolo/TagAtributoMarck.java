package tcc.vinicius.html.busca.tag.simbolo;

public class TagAtributoMarck implements Marck {

    private final String de;
    private final String para;

    public TagAtributoMarck(String de, String para) {
        this.de = de;
        this.para = para;
    }

    @Override
    public String converteParaHTML(String html) {
        return html.replaceAll("\\["+de+"(.*)\\]","<"+ para+"$1 />");
    }
}
