package tcc.vinicius.html.busca.tag.simbolo;

import java.util.ArrayList;
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
        try {
            circundarStringComTagLi(lista);
        } catch (Exception e) {
        }
        tagLista = tagLista + "</ul>";
        return tagLista;
    }

    private List<String> listaDeItens(String html) {
        return Arrays.asList(html.trim().split("( \\* )"));
    }

    private String circundarStringComTagLi(List<String> lista) {
        tagLista = tagLista + "<li>" + lista.get(0).replace("* ", "").trim() + "</li>";
        lista = lista.subList(1, lista.size());
        return circundarStringComTagLi(lista);
    }
}
