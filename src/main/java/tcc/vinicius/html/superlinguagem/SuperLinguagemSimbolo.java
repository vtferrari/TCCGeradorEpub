package tcc.vinicius.html.superlinguagem;

import java.util.HashSet;
import java.util.Set;
import tcc.vinicius.html.busca.tag.simbolo.ConversorHTML;
import tcc.vinicius.html.busca.tag.simbolo.LinkMascara;
import tcc.vinicius.html.busca.tag.simbolo.LinkSimples;
import tcc.vinicius.html.busca.tag.simbolo.Simbolo;
import tcc.vinicius.html.busca.tag.simbolo.TagAtributada;
import tcc.vinicius.html.busca.tag.simbolo.TagColchetes;
import tcc.vinicius.html.busca.tag.simbolo.TagLista;

public class SuperLinguagemSimbolo {

    public String paraHTML(String html) {
        Set<ConversorHTML> lista = new HashSet<>();

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
        
        String processar = html;
        for (ConversorHTML lista1 : lista) {
            processar = lista1.converteParaHTML(processar);
        }
        return processar;
    }

}
