package tcc.vinicius.html.superlinguagem;

import java.util.ArrayList;
import java.util.List;
import tcc.vinicius.html.busca.tag.simbolo.Marck;
import tcc.vinicius.html.busca.tag.simbolo.LinkMascaraMarck;
import tcc.vinicius.html.busca.tag.simbolo.LinkSimplesMarck;
import tcc.vinicius.html.busca.tag.simbolo.NormalizarLinkMarck;
import tcc.vinicius.html.busca.tag.simbolo.SimboloMarck;
import tcc.vinicius.html.busca.tag.simbolo.TagAtributoMarck;
import tcc.vinicius.html.busca.tag.simbolo.ColchetesMarck;
import tcc.vinicius.html.busca.tag.simbolo.ListaMarck;
import tcc.vinicius.html.busca.tag.simbolo.ParagrafoMarck;

public class MarckupChain {

    public String paraHTML(String html) {
        List<Marck> lista = new ArrayList<>();

        lista.add(new ColchetesMarck("i"));
        lista.add(new ColchetesMarck("u"));
        lista.add(new ColchetesMarck("b"));
        lista.add(new SimboloMarck("__", "u"));
        lista.add(new SimboloMarck("//", "i"));
        lista.add(new SimboloMarck("\\*\\*", "b"));
        lista.add(new ListaMarck());
        lista.add(new LinkSimplesMarck());
        lista.add(new LinkMascaraMarck());
        lista.add(new TagAtributoMarck("image", "img"));
        lista.add(new NormalizarLinkMarck());
        lista.add(new ParagrafoMarck());
        
        String processar = html;
        for (Marck lista1 : lista) {
            processar = lista1.converteParaHTML(processar);
        }
        return processar;
    }

}
