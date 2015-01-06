package tcc.vinicius.html.busca.tag.simbolo;


public class LinkMascara implements BuscaTagSPL {

    @Override
    public String converteParaHTML(String html) {
        String enderecoWeb = html.substring(html.indexOf("[")+1, html.indexOf("]"));
        String mascaraLink = html.substring(html.indexOf("(")+1, html.indexOf(")"));
       
        return html.replaceFirst("\\[.*\\]\\(.*\\)",
                "<a href=\"" + enderecoWeb.replace("<i>", "//") + "\">" + mascaraLink + "</a>");
    }
    
}