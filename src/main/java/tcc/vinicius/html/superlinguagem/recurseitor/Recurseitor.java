
package tcc.vinicius.html.superlinguagem.recurseitor;

import java.util.List;
import tcc.vinicius.html.busca.tag.simbolo.BuscaTagSPL;



public class Recurseitor {
    
    public static String html;
    
    public static List<BuscaTagSPL> percorreLista(List<BuscaTagSPL> lista) throws IndexOutOfBoundsException {
        html = (lista.get(lista.size() - 1).converteParaHTML(html));
        return percorreLista(lista.subList(0, lista.size() - 1));
    }

}
