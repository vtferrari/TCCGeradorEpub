package tcc.vinicius.html.superlinguagem;

import java.util.ArrayList;
import java.util.List;
import tcc.vinicius.html.busca.tag.simbolo.BuscaTagSPL;
import tcc.vinicius.html.busca.tag.simbolo.LinkMascara;
import tcc.vinicius.html.busca.tag.simbolo.LinkSimples;
import tcc.vinicius.html.busca.tag.simbolo.Simbolo;
import tcc.vinicius.html.busca.tag.simbolo.TagLista;
import tcc.vinicius.html.superlinguagem.recurseitor.Recurseitor;

public class SuperLinguagemSimbolo implements SuperLinguagem {

    private String html;

    @Override
    public String paraHTML(String html) {
        Recurseitor.html = html;
        List<BuscaTagSPL> lista = new ArrayList<>();

        lista.add(new LinkMascara());
        lista.add(new LinkSimples());
        lista.add(new Simbolo("\\*\\*", "b"));
        lista.add(new Simbolo("//", "i"));
        lista.add(new Simbolo("__", "u"));
        lista.add(new TagLista());

        Recurseitor.percorreLista(lista);

        return Recurseitor.html;
    }

}
