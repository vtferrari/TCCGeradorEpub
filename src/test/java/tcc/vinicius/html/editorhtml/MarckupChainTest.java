package tcc.vinicius.html.editorhtml;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import tcc.vinicius.html.superlinguagem.MarckupChain;

public class MarckupChainTest {

    MarckupChain edit;

    @Before
    public void setUp() {
        edit = new MarckupChain();

    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagUViniciusU() {
        assertEquals("<u>Vinicius</u>", edit.paraHTML("[u]Vinicius[/u]"));
        assertEquals("<u>Ferrari</u>", edit.paraHTML("[u]Ferrari[/u]"));
        assertEquals("<u>Vinicius</u> <u>Ferrari</u>", edit.paraHTML("[u]Vinicius[/u] [u]Ferrari[/u]"));
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagBFerrariB() {
        assertEquals("<b>Vinicius</b>", edit.paraHTML("[b]Vinicius[/b]"));
        assertEquals("<b>Ferrari</b>", edit.paraHTML("[b]Ferrari[/b]"));
        assertEquals("<b>Vinicius</b> <b>Ferrari</b>", edit.paraHTML("[b]Vinicius[/b] [b]Ferrari[/b]"));
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagIViniciusI() {
        assertEquals("<i>Vinicius</i>", edit.paraHTML("[i]Vinicius[/i]"));
        assertEquals("<i>Ferrari</i>", edit.paraHTML("[i]Ferrari[/i]"));
        assertEquals("<i>Vinicius</i> <i>Ferrari</i>", edit.paraHTML("[i]Vinicius[/i] [i]Ferrari[/i]"));
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTag__Viniciu_____Ferrari__() {
        assertEquals("<u>Vinicius</u> <u>Ferrari</u>", edit.paraHTML("__Vinicius__ __Ferrari__"));
    }


    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagBarraBarraViniciuBarraBarraFerrariBarraBarra() {
        assertEquals("<i>Vinicius</i> <i>Ferrari</i>", edit.paraHTML("//Vinicius// //Ferrari//"));
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagAsteriscoAsteriscoFerrariAsteriscoAsterisco() {
        assertEquals("<b>Ferrari</b>", edit.paraHTML("**Ferrari**"));
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterLinkEmTag() {
        String transformado = edit.paraHTML("http://www.google.com");
        assertEquals("<a href=\"http://www.google.com\">http://www.google.com</a>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterLista() {
        String transformado = edit.paraHTML("* item 1 * item 2 * item 3");
        assertEquals("<ul><li>item 1</li><li>item 2</li><li>item 3</li></ul>", transformado);
    }
    
        @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagUumBexemploIqualquerIBU() {
        String transformado = edit.paraHTML("[u]um [b]exemplo [i]qualquer[/i][/b][/u]");
        assertEquals("<u>um <b>exemplo <i>qualquer</i></b></u>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterTagImagem() {
        String transformado = edit.paraHTML("[image src=\"caminho qualquer\"]");
        assertEquals("<img src=\"caminho qualquer\" />", transformado);
    }

}
