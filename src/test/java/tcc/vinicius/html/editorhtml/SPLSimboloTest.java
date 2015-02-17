package tcc.vinicius.html.editorhtml;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import tcc.vinicius.html.superlinguagem.SuperLinguagemSimbolo;

public class SPLSimboloTest {

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTag__Ferrari__() {
        SuperLinguagemSimbolo edit = new SuperLinguagemSimbolo();
        String transformado = edit.paraHTML("__Ferrari__");
        assertEquals("<u>Ferrari</u>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTag__Viniciu_____Ferrari__() {
        SuperLinguagemSimbolo edit = new SuperLinguagemSimbolo();
        String transformado = edit.paraHTML("__Vinicius__ __Ferrari__");
        assertEquals("<u>Vinicius</u> <u>Ferrari</u>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagBarraBarraFerrariBarraBarra() {
        SuperLinguagemSimbolo edit = new SuperLinguagemSimbolo();
        String transformado = edit.paraHTML("//Ferrari//");
        assertEquals("<i>Ferrari</i>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagBarraBarraViniciuBarraBarraFerrariBarraBarra() {
        SuperLinguagemSimbolo edit = new SuperLinguagemSimbolo();
        String transformado = edit.paraHTML("//Vinicius// //Ferrari//");
        assertEquals("<i>Vinicius</i> <i>Ferrari</i>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagAsteriscoAsteriscoFerrariAsteriscoAsterisco() {
        SuperLinguagemSimbolo edit = new SuperLinguagemSimbolo();
        String transformado = edit.paraHTML("**Ferrari**");
        assertEquals("<b>Ferrari</b>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterLinkEmTag() {
        SuperLinguagemSimbolo edit = new SuperLinguagemSimbolo();
        String transformado = edit.paraHTML("http://www.google.com");
        assertEquals("<a href=\"http://www.google.com\">http://www.google.com</a>", transformado);
    }


    @Test
    public void testeSeOEditorAchaPadraoParaComverterLista() {
        SuperLinguagemSimbolo edit = new SuperLinguagemSimbolo();
        String transformado = edit.paraHTML("* item 1 * item 2 * item 3");
        assertEquals("<ul><li>item 1</li><li>item 2</li><li>item 3</li></ul>", transformado);
    }

}
