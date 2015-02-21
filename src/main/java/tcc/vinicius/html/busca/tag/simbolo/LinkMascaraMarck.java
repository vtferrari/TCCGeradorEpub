package tcc.vinicius.html.busca.tag.simbolo;


public class LinkMascaraMarck implements Marck {

    @Override
    public String converteParaHTML(String html) {
       
        return html.replaceFirst("\\[(.*)\\]\\((.*)\\)",
                "<a href=\"$1\">$2</a>").trim();
    }
    
}