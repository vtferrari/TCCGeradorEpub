package tcc.vinicius.html.busca.tag.simbolo;


public class LinkSimples implements ConversorHTML {

    @Override
    public String converteParaHTML(String html) {
        return html.replaceFirst(".*(http|https|ftp)*[a-z]$", 
                "<a href=\"" + html + "\">" + html + "</a>");
    }
    
}
