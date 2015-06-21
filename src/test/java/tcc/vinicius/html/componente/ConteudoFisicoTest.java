package tcc.vinicius.html.componente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConteudoFisicoTest {

    @After
    public void depois() {
        List<File> files = new ArrayList<>();
        files.add(new File("nomeArquivo.html"));
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }

        }
    }

    @Test
    public void testeDeveCriarUmaPastaComOParaGuardarConteudoDoLivro() {
        ConteudoFisico conteudoFisico = new ConteudoFisico("", "/");
        assertTrue(conteudoFisico.isLocalExiste());
    }

    @Test
    public void testeDeveCriarArquivoParaGravarNaPastaDoLivro() {
        ConteudoFisico conteudoFisico = new ConteudoFisico("nomeArquivo", "/home/vinicius/Vinicius/Netbeans/TCCGeradorEpub/");
        assertTrue(conteudoFisico.isLocalExiste());
        assertTrue(conteudoFisico.salvarArquivo("").exists());
    }

    @Test
    public void testeDeveCriarArquivoComConteudoParaGravarNaPastaDoLivro() {
        ConteudoFisico conteudoFisico = new ConteudoFisico("nomeArquivo", "/home/vinicius/Vinicius/Netbeans/TCCGeradorEpub/");
        assertTrue(conteudoFisico.isLocalExiste());
        File salvarArquivo = conteudoFisico.salvarArquivo("conteudo");
        assertFalse(isVazio(salvarArquivo));
    }

    private boolean isVazio(File f) {
        String s = "";
        try {
            try (FileReader arq = new FileReader(f)) {
                BufferedReader lerArq = new BufferedReader(arq);

                String linha = lerArq.readLine();
                while (linha != null) {
                    linha = lerArq.readLine();
                    s += linha;
                }
                lerArq.close();
            }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return s.isEmpty();
    }

}
