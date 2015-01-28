package tcc.vinicius.html.busca.tag.simbolo;

import java.util.Arrays;
import java.util.List;

public class TagLista implements BuscaTagSPL {

    private String tagLista;

    @Override
    public String converteParaHTML(String html) {
        return (html.replaceFirst(".*(\\* ).*", circundaListaComTagLi(listaDeItens(html))));
    }

    private String circundaListaComTagLi(List<String> lista) {
        tagLista = "<ul>";
        for (String lis : lista) {
            tagLista += "<li>" + lis.replace("* ", "").trim() + "</li>";
        }
        tagLista += "</ul>";
        return tagLista;
    }

    private List<String> listaDeItens(String html) {
        return Arrays.asList(html.trim().split("( \\* )"));
    }
}
