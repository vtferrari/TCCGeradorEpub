package tcc.vinicius.geradorepub.mb;

import com.sun.java.accessibility.util.Translator;
import com.vhly.epubmaker.epub.EPubFile;
import com.vhly.epubmaker.epub.Item;
import com.vhly.epubmaker.epub.content.Chapter;
import java.io.InputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Metadata;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.domain.TOCReference;

import nl.siegmann.epublib.epub.EpubWriter;

@ManagedBean
@SessionScoped
public class AutoriaMB implements Serializable {

    EPubFile file = new EPubFile();

    public void criarEpub() {

        file.setTitle("Test");
        file.setAuthor("vhly[FR]");
        file.setUUID("998482814");
        file.setDescript("This is a Test");
        Chapter ch = new Chapter();
        ch.setTitle("Chapter001");
        ch.setEntryName("chapter001.html");
        ch.setPageContent("<html>"
                + "<body>"
                + "<h4 class=\"calibre4\">Encapsulamento</h4><p class=\"calibre3\">Se uma aplicação precisa de um conjunto de objetos, devem haver classes que abstraiam esses conceitos. Porém, esses mesmos objetos podem precisar ser tratados em partes diferentes do software a partir de diferentes níveis de abstração. O Garfield e o Frajola podem ser tratados como gatos em uma parte do sistema, porém outra, que precisar também lidar com os objetos Pica-pau e Mickey Mouse, pode precisar de um conceito mais abstrato, como animal ou personagem.</p><p class=\"calibre3\">A <strong class=\"calibre6\">herança</strong> é uma característica do paradigma orientado a objetos que permite que abstrações possam ser definidas em diversos níveis. Considerando que você tem uma classe, ela pode ser especializada por uma outra que irá definir um conceito mais concreto. Por outro lado, um conjunto de classes pode ser generalizado por uma classe que representa um conceito mais abstrato. Quando uma classe estende outra, ela não só herda a estrutura de dados e o comportamento da superclasse, mas também o contrato que ela mantém com os seus clientes.</p>"
                + "</body>"
                + "</html>");
        Item chapterItem = new Item("chapter001.html", "chapter001.html");
        ch.setChapterItem(chapterItem);
        file.addChapter(ch);
        file.save("C:\\Users\\Reinaldo\\Documents\\NetBeansProjects\\GeradorEpub\\src\\main\\webapp\\resources\\optimus.epub");
    }

    private StreamedContent download;

    public AutoriaMB() {
        InputStream stream = ((javax.servlet.ServletContext) FacesContext.
                getCurrentInstance().
                getExternalContext().
                getContext()).getResourceAsStream("/resources/optimus.epub");
        download = new DefaultStreamedContent(stream, "application/epub+zip", "optimus.epub");
    }

    public StreamedContent getFile() {
        return download;
    }

    private static InputStream getResource(String path) {
        return Translator.class.getResourceAsStream(path);
    }

    private static Resource getResource(String path, String href) throws IOException {
        return new Resource(getResource(path), href);
    }

    public static void main(String[] args) {
        try {
            // Create new Book
            Book book = new Book();
            Metadata metadata = book.getMetadata();

            // Set the title
            metadata.addTitle("Epublib test book 1");

            // Add an Author
            metadata.addAuthor(new Author("Joe", "Tester"));

            // Set cover image
            book.setCoverImage(
                    getResource("/book1/test_cover.png", "cover.png"));

            // Add Chapter 1
            book.addSection("Introduction",
                    getResource("/book1/chapter1.html", "chapter1.html"));

            // Add css file
            book.getResources().add(
                    getResource("/book1/book1.css", "book1.css"));

            // Add Chapter 2
            TOCReference chapter2 = book.addSection("Second Chapter",
                    getResource("/book1/chapter2.html", "chapter2.html"));

            // Add image used by Chapter 2
            book.getResources().add(
                    getResource("/book1/flowers_320x240.jpg", "flowers.jpg"));

            // Add Chapter2, Section 1
            book.addSection(chapter2, "Chapter 2, section 1",
                    getResource("/book1/chapter2_1.html", "chapter2_1.html"));

            // Add Chapter 3
            book.addSection("Conclusion",
                    getResource("/book1/chapter3.html", "chapter3.html"));

            // Create EpubWriter
            EpubWriter epubWriter = new EpubWriter();

            // Write the Book as Epub
            epubWriter.write(book, new FileOutputStream("test1_book1.epub"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
