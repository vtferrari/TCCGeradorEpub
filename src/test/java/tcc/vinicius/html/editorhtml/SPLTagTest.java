/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.vinicius.html.editorhtml;

import org.junit.Test;
import static org.junit.Assert.*;
import tcc.vinicius.html.superlinguagem.SuperLinguagem;
import tcc.vinicius.html.superlinguagem.SuperLinguagemTag;

public class SPLTagTest {

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagUViniciusU() {
        SuperLinguagem transforma = new SuperLinguagemTag();
        String transformado = transforma.paraHTML("[u]Vinicius[/u]");
        assertEquals("<u>Vinicius</u>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagUFerrariU() {
        SuperLinguagem edit = new SuperLinguagemTag();
        String transformado = edit.paraHTML("[u]Ferrari[/u]");
        assertEquals("<u>Ferrari</u>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagBViniciusB() {
        SuperLinguagem edit = new SuperLinguagemTag();
        String transformado = edit.paraHTML("[b]Vinicius[/b]");
        assertEquals("<b>Vinicius</b>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagBFerrariB() {
        SuperLinguagem edit = new SuperLinguagemTag();
        String transformado = edit.paraHTML("[b]Ferrari[/b]");
        assertEquals("<b>Ferrari</b>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagIViniciusI() {
        SuperLinguagem edit = new SuperLinguagemTag();
        String transformado = edit.paraHTML("[i]Vinicius[/i]");
        assertEquals("<i>Vinicius</i>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagIFerrariI() {
        SuperLinguagem edit = new SuperLinguagemTag();
        String transformado = edit.paraHTML("[i]Ferrari[/i]");
        assertEquals("<i>Ferrari</i>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterEmTagUumBexemploIqualquerIBU() {
        SuperLinguagem edit = new SuperLinguagemTag();
        String transformado = edit.paraHTML("[u]um [b]exemplo [i]qualquer[/i][/b][/u]");
        assertEquals("<u>um <b>exemplo <i>qualquer</i></b></u>", transformado);
    }

    @Test
    public void testeSeOEditorAchaPadraoParaComverterTagImagem() {
        SuperLinguagem edit = new SuperLinguagemTag();
        String transformado = edit.paraHTML("[image src=\"caminho qualquer\"]");
        assertEquals("<img src=\"caminho qualquer\" />", transformado);
    }

}
