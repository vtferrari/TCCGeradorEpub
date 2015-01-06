package tcc.vinicius.geradorepub.mb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Date;
import nl.siegmann.epublib.epub.EpubWriter;

public abstract class EBook implements Serializable {

    protected Book epub;

    public EBook() {
        epub = new Book();
        if (epub.getMetadata().getDates().isEmpty()) {
            epub.getMetadata().addDate(new Date(new java.util.Date()));
        }
    }

    public Book getEpub() {
        return epub;
    }

    public void publicar(String nomeArquivo) {
        try {
            EpubWriter epubWriter = new EpubWriter();
            epubWriter.write(epub, new FileOutputStream(nomeArquivo + ".epub"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Autoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Autoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
