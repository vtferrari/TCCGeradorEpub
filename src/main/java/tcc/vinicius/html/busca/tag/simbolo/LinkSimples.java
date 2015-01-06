package tcc.vinicius.html.busca.tag.simbolo;


public class LinkSimples implements BuscaTagSPL {

    @Override
    public String converteParaHTML(String html) {
        return html.replaceFirst(".*(http|https|ftp)*[a-z]$", 
                "<a href=\"" + html.replace("<i>", "//") + "\">" + html.replace("<i>", "//") + "</a>");
    }
    
}
