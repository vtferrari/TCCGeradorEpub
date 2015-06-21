package tcc.vinicius.mvc.controler;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
import tcc.vinicius.mvn.model.Capitulo;
import tcc.vinicius.mvn.model.Livro;

public class LivroControlerTest {

    @Test
    public void testControleContinuarDevolveUmLinkSeLivroNaoNulo() {
        LivroController livroControler = new LivroController();
        Livro livro = new Livro();
        livro.setTitulo("TDD");
        livroControler.setLivro(livro);
        String link = livroControler.continuar();
        assertEquals("editor.xhtml", link);
    }

    @Test
    public void testControledContinuarVerificaVazioDeveFicarNaMesmaTela() {
        LivroController livroControler = new LivroController();
        Livro livro = null;
        livroControler.setLivro(livro);
        String link = livroControler.continuar();
        assertNull(link);
    }

    @Test
    public void testControledNaoDeveAdicionarUmCapituloVazio() {
        LivroController livroControler = new LivroController();
        Capitulo capitulo = null;
        livroControler.setCapitulo(capitulo);
        String link = livroControler.addCapitulo(capitulo);
        assertNull(link);
    }

    @Test
    public void testControledDeveAdicionarUmCapituloAlistaDeConteudo() {
        LivroController livroControler = new LivroController();
        Capitulo capitulo = new Capitulo();
        capitulo.setTitulo("Teste");
        capitulo.setConteudo("conteudo!!!");
        livroControler.setCapitulo(capitulo);
        String link = livroControler.addCapitulo(capitulo);
        assertNotNull(link);
        assertEquals(1, livroControler.tabelaDeConteudo().size());
        assertEquals("Teste", livroControler.tabelaDeConteudo().get(0).getTitulo());
        assertEquals("conteudo!!!", livroControler.tabelaDeConteudo().get(0).getConteudo());
    }

    @Test
    public void testControledDeveProcessarOconteudoDeVariosCapitulosETransformaConteudoEmUmHTML() throws Exception {
        LivroController livroControler = new LivroController();
        Capitulo capitulo1 = new Capitulo();
        capitulo1.setTitulo("Teste");
        capitulo1.setConteudo("conteudo!!!");
        Capitulo capitulo2 = new Capitulo();
        capitulo2.setTitulo("Teste");
        capitulo2.setConteudo("**conteudo2!!!**");
        livroControler.addCapitulo(capitulo1);
        livroControler.addCapitulo(capitulo2);
        livroControler.setCapitulo(capitulo2);
        assertEquals(capitulo2, livroControler.getCapitulo());
        assertEquals("finalizado",livroControler.finalizarLivro());
        assertEquals(2, livroControler.tabelaDeConteudo().size());
        assertEquals("Teste", livroControler.tabelaDeConteudo().get(0).getTitulo());
        assertEquals("<p>conteudo!!!</p>", livroControler.tabelaDeConteudo().get(0).getConteudo());
        assertEquals("Teste", livroControler.tabelaDeConteudo().get(1).getTitulo());
        assertEquals("<p><b>conteudo2!!!</b></p>", livroControler.tabelaDeConteudo().get(1).getConteudo());
    }
    
//    @Test
    public void testControledDeveProcessarOconteudoSalvaEPUB_EmC_Temp() throws Exception {
        LivroController livroControler = new LivroController();
        Capitulo capitulo1 = new Capitulo();
        capitulo1.setTitulo("Teste");
        capitulo1.setConteudo("conteudo!!!");
        Capitulo capitulo2 = new Capitulo();
        capitulo2.setTitulo("Teste");
        capitulo2.setConteudo("**conteudo2!!!**");
        livroControler.addCapitulo(capitulo1);
        livroControler.addCapitulo(capitulo2);
        assertEquals("finalizado",livroControler.finalizarLivro());
        assertEquals(2, livroControler.tabelaDeConteudo().size());
        assertEquals("Teste", livroControler.tabelaDeConteudo().get(0).getTitulo());
        assertEquals("<p>conteudo!!!</p>", livroControler.tabelaDeConteudo().get(0).getConteudo());
        assertEquals("Teste", livroControler.tabelaDeConteudo().get(1).getTitulo());
        assertEquals("<p><b>conteudo2!!!</b></p>", livroControler.tabelaDeConteudo().get(1).getConteudo());
        assertTrue(new File("c:\\temp\\nao_tem_o_arquivo.epub").exists());
    }

}
