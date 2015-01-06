package tcc.vinicius.geradorepub.mb;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import nl.siegmann.epublib.domain.Resource;

@ManagedBean
@SessionScoped
public class Capitulo extends EBook {

    private String titulo;
    private String conteudo;

    public void addCapitulo(String html) {
        epub.addSection(titulo, new Resource(html.getBytes(), "capitulo" + epub.getContents().size() + ".xhtml"));
    }

    public void addCapitulo() {
        addCapitulo(processConteudo());
    }

    public List<Resource> getCapitulos() {
        return epub.getContents();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private String processConteudo() {

        String html
                = "<?xml version='1.0' encoding='utf-8'?>\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                + "  <head>\n"
                + "    <title>" + titulo + "</title>\n"
                + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n"
                + "  </head>\n"
                + "  <body>\n"
                + "    <div>" + conteudo + "</div>\n"
                + "  </body>"
                + "</html>";
        return html;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

}
