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

public class EBook {

    private Book epub;

    public EBook(Book epub) {
        this.epub = epub;
        if (this.epub.getMetadata().getDates().isEmpty()) {
            this.epub.getMetadata().addDate(new Date(new java.util.Date()));
        }
    }

    public Book getEpub() {
        return epub;
    }

    public void publicar(String nomeArquivo) {
        try {
            EpubWriter epubWriter = new EpubWriter();
            System.out.println(epubWriter);
            System.out.println(epub);
            epubWriter.write(epub, new FileOutputStream(nomeArquivo + ".epub"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Autoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Autoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
