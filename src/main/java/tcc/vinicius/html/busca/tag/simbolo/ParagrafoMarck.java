package tcc.vinicius.html.busca.tag.simbolo;

public class ParagrafoMarck implements Marck {

    @Override
    public String converteParaHTML(String html) {
        return html.replaceAll("^", "<p>").replaceAll("\n", "</p><p>").replaceFirst("<p>$", "");
    }

}
