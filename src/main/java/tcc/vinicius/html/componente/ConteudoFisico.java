package tcc.vinicius.html.componente;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConteudoFisico {

    public final String local;
    public final String nomeArquivo;

    public ConteudoFisico(String nomeArquivo, String local) {
        this.local = local;
        this.nomeArquivo = nomeArquivo;
    }

    public boolean isLocalExiste() {
        return new File(local).exists();
    }

    public File salvarArquivo(String conteudo) {
        File file = new File(local + nomeArquivo + ".html");
        try {
            file.createNewFile();

            try (FileWriter arq = new FileWriter(file)) {
                PrintWriter gravarArq = new PrintWriter(arq);

                gravarArq.printf(conteudo);

                gravarArq.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(ConteudoFisico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return file;
    }

}
