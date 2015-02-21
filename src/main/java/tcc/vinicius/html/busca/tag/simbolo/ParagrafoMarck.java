package tcc.vinicius.html.busca.tag.simbolo;

import tcc.vinicius.html.busca.tag.simbolo.Marck;

public class ParagrafoMarck implements Marck {

    @Override
    public String converteParaHTML(String html) {
        return html.replaceAll("^", "<p>").replaceAll("\n", "</p><p>").replaceFirst("<p>$", "");
    }

}
