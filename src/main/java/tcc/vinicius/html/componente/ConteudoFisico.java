package tcc.vinicius.html.componente;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    public File salvarArquivo(String conteudo) throws IOException {
        File file = new File(local + nomeArquivo + ".html");
            file.createNewFile();

            try (FileWriter arq = new FileWriter(file)) {
                PrintWriter gravarArq = new PrintWriter(arq);

                gravarArq.printf(conteudo);

                gravarArq.close();
            }

        return file;
    }

}
