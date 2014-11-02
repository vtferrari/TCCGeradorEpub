package com.vhly.epubmaker;

import com.vhly.epubmaker.epub.EPubFile;
import com.vhly.epubmaker.epub.Item;
import com.vhly.epubmaker.epub.content.Chapter;

/**
 * Created by IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 11-12-2
 * Email: vhly@163.com
 */
public class MakeTest {
    public static void main(String[] args) {
        EPubFile file = new EPubFile();
        file.setTitle("Test");
        file.setAuthor("vhly[FR]");
        file.setUUID("998482814");
        file.setDescript("This is a Test");
        Chapter ch = new Chapter();
        ch.setTitle("Chapter001");
        ch.setEntryName("chapter001.html");
        ch.setPageContent("<html><body><h4 class=\"calibre4\">Encapsulamento</h4><p class=\"calibre3\">Se uma aplicação precisa de um conjunto de objetos, devem haver classes que abstraiam esses conceitos. Porém, esses mesmos objetos podem precisar ser tratados em partes diferentes do software a partir de diferentes níveis de abstração. O Garfield e o Frajola podem ser tratados como gatos em uma parte do sistema, porém outra, que precisar também lidar com os objetos Pica-pau e Mickey Mouse, pode precisar de um conceito mais abstrato, como animal ou personagem.</p><p class=\"calibre3\">A <strong class=\"calibre6\">herança</strong> é uma característica do paradigma orientado a objetos que permite que abstrações possam ser definidas em diversos níveis. Considerando que você tem uma classe, ela pode ser especializada por uma outra que irá definir um conceito mais concreto. Por outro lado, um conjunto de classes pode ser generalizado por uma classe que representa um conceito mais abstrato. Quando uma classe estende outra, ela não só herda a estrutura de dados e o comportamento da superclasse, mas também o contrato que ela mantém com os seus clientes.</p></body></html>");
        Item chapterItem = new Item("chapter001.html","chapter001.html");
        ch.setChapterItem(chapterItem);
        file.addChapter(ch);
        file.save("./MakeTest.epub");
    }
}
