package tcc.vinicius.html.busca.tag.simbolo;

public class SimboloMarck implements Marck {

    private final String de;
    private final String para;

    public SimboloMarck(String de, String para) {
        this.de = de;
        this.para = para;
    }

    @Override
    public String converteParaHTML(String html) {
        return html.replaceAll(de + "([^" + de + "]+)" + de, "<" + para + ">$1</" + para + ">");
    }
}
