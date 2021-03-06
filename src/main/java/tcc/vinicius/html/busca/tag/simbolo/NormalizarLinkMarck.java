package tcc.vinicius.html.busca.tag.simbolo;

public class NormalizarLinkMarck implements Marck {

    @Override
    public String converteParaHTML(String html) {
        if (html.matches(".*[(http|https|ftp)]:.*")) {
            return html.replaceAll("<[a-zA-Z]+>", "//");
        }
        return html;
    }

}
