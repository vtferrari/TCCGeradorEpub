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
        assertEquals("<p><u>Vinicius</u></p>", edit.paraHTML("[u]Vinicius[/u]"));
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagBFerrariB() {
        assertEquals("<p><b>Vinicius</b></p>", edit.paraHTML("[b]Vinicius[/b]"));
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagIViniciusI() {
        assertEquals("<p><i>Vinicius</i></p>", edit.paraHTML("[i]Vinicius[/i]"));
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTag__Viniciu_____Ferrari__() {
        assertEquals("<p><u>Vinicius</u> <u>Ferrari</u></p>", edit.paraHTML("__Vinicius__ __Ferrari__"));
    }


    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagBarraBarraViniciuBarraBarraFerrariBarraBarra() {
        assertEquals("<p><i>Vinicius</i> <i>Ferrari</i></p>", edit.paraHTML("//Vinicius// //Ferrari//"));
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagAsteriscoAsteriscoFerrariAsteriscoAsterisco() {
        assertEquals("<p><b>Ferrari</b></p>", edit.paraHTML("**Ferrari**"));
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterLinkEmTag() {
        String transformado = edit.paraHTML("http://www.google.com");
        assertEquals("<p><a href=\"http://www.google.com\">http://www.google.com</a></p>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterLista() {
        String transformado = edit.paraHTML("* item 1 * item 2 * item 3");
        assertEquals("<p><ul><li>item 1</li><li>item 2</li><li>item 3</li></ul></p>", transformado);
    }
    
        @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagUumBexemploIqualquerIBU() {
        String transformado = edit.paraHTML("[u]um [b]exemplo [i]qualquer[/i][/b][/u]");
        assertEquals("<p><u>um <b>exemplo <i>qualquer</i></b></u></p>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterTagImagem() {
        String transformado = edit.paraHTML("[image src=\"caminho qualquer\"]");
        assertEquals("<p><img src=\"caminho qualquer\" /></p>", transformado);
    }

}
