package tcc.vinicius.html.busca.tag.simbolo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ColchetesMarckTest {

    @Test
    public void testeSeConverterTagFalsaUParaViniciusTagHTMLU() {
        String u = "u";
        ColchetesMarck transforma = new ColchetesMarck(u);
        assertEquals("<u>Vinicius</u> <u>Ferrari</u>", transforma.converteParaHTML("[u]Vinicius[/u] [u]Ferrari[/u]"));
    }
    @Test
    public void testeADeveSerA() {
        String u = "a";
        ColchetesMarck transforma = new ColchetesMarck(u);
        assertEquals("a", transforma.converteParaHTML("a"));
    }

}
