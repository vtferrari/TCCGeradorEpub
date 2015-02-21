package tcc.vinicius.html.busca.tag.simbolo;


public class LinkMascara implements ConversorHTML {

    @Override
    public String converteParaHTML(String html) {
       
        return html.replaceFirst("\\[(.*)\\]\\((.*)\\)",
                "<a href=\"$1\">$2</a>").trim();
    }
    
}