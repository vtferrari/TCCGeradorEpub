package tcc.vinicius.html.superlinguagem;

import java.util.ArrayList;
import java.util.List;
import tcc.vinicius.html.busca.tag.simbolo.BuscaTagSPL;
import tcc.vinicius.html.busca.tag.simbolo.TagAtributada;
import tcc.vinicius.html.busca.tag.simbolo.TagColchetes;
import tcc.vinicius.html.superlinguagem.recurseitor.Recurseitor;

public class SuperLinguagemTag implements SuperLinguagem {

    @Override
    public String paraHTML(String html) {
        Recurseitor.html = html;

        List<BuscaTagSPL> lista = new ArrayList<>();

        lista.add(new TagAtributada("image", "img"));
        lista.add(new TagColchetes("b"));
        lista.add(new TagColchetes("u"));
        lista.add(new TagColchetes("i"));

        try {
            Recurseitor.percorreLista(lista);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("erro");
        }

        return Recurseitor.html;
    }

}
