package tcc.vinicius.html.busca.tag.simbolo;


public class LinkSimplesMarck implements Marck {

    @Override
    public String converteParaHTML(String html) {
        return html.replaceFirst(".*(http|https|ftp)*[a-z]$", 
                "<a href=\"" + html + "\">" + html + "</a>");
    }
    
}
