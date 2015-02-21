package tcc.vinicius.html.busca.tag.simbolo;

import org.junit.Test;
import static org.junit.Assert.*;

public class TagColchetesTest {

    @Test
    public void testeSeConverterTagFalsaUParaViniciusTagHTMLU() {
        String u = "u";
        TagColchetes transforma = new TagColchetes(u);
        assertEquals("<u>Vinicius</u> <u>Ferrari</u>", transforma.converteParaHTML("[u]Vinicius[/u] [u]Ferrari[/u]"));
    }

}
