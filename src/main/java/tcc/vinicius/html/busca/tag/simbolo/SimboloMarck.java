package tcc.vinicius.html.busca.tag.simbolo;

import java.util.regex.PatternSyntaxException;

public class SimboloMarck implements Marck {

    private final String de;
    private final String para;

    public SimboloMarck(String de, String para) {
        this.de = de;
        this.para = para;
    }

    @Override
    public String converteParaHTML(String html) {
        if (de.matches("^[a-zA-Z].*") || de.matches(".*[a-zA-Z]$")) {
            throw new PatternSyntaxException("Não de iniciar ou terminar com letra", de, 0);
        }
        return html.replaceAll(de + "([^" + de + "]+)" + de, "<" + para + ">$1</" + para + ">");
    }
}
