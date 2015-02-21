package tcc.vinicius.html.busca.tag.simbolo;

import java.util.Arrays;
import java.util.List;

public class ListaMarck implements Marck {

    private String listTag;

    @Override
    public String converteParaHTML(String html) {
        return html.replaceFirst(".*(\\* ).*", circundaListaComTagLi(listaDeItens(html)));
    }

    private String circundaListaComTagLi(List<String> lista) {
        listTag = "<ul>";
        for (String lis : lista) {
            listTag += "<li>" + lis.replace("* ", "").trim() + "</li>";
        }
        listTag += "</ul>";
        return listTag;
    }

    private List<String> listaDeItens(String html) {
        return Arrays.asList(html.trim().split("( \\* )"));
    }
}
