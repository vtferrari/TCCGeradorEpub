package tcc.vinicius.html.superlinguagem;

import java.util.HashSet;
import java.util.Set;
import tcc.vinicius.html.busca.tag.simbolo.BuscaTagSPL;
import tcc.vinicius.html.busca.tag.simbolo.LinkMascara;
import tcc.vinicius.html.busca.tag.simbolo.LinkSimples;
import tcc.vinicius.html.busca.tag.simbolo.Simbolo;
import tcc.vinicius.html.busca.tag.simbolo.TagAtributada;
import tcc.vinicius.html.busca.tag.simbolo.TagColchetes;
import tcc.vinicius.html.busca.tag.simbolo.TagLista;

public class SuperLinguagemSimbolo {

    public String paraHTML(String html) {
        Set<BuscaTagSPL> lista = new HashSet<>();

        lista.add(new TagColchetes("i"));
        lista.add(new TagColchetes("u"));
        lista.add(new TagColchetes("b"));
        lista.add(new Simbolo("__", "u"));
        lista.add(new Simbolo("//", "i"));
        lista.add(new Simbolo("\\*\\*", "b"));
        lista.add(new TagLista());
        lista.add(new LinkSimples());
        lista.add(new LinkMascara());
        lista.add(new TagAtributada("image", "img"));
        

        for (BuscaTagSPL lista1 : lista) {
            html = lista1.converteParaHTML(html);
        }
        return html;
    }

}
