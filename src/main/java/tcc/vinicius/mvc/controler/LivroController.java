package tcc.vinicius.mvc.controler;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tcc.vinicius.html.componente.Epub;
import tcc.vinicius.html.superlinguagem.MarckupChain;
import tcc.vinicius.mvn.model.Capitulo;
import tcc.vinicius.mvn.model.Livro;

@ManagedBean
@SessionScoped
public class LivroController implements Serializable {

    private transient final List<Capitulo> conteudo;
    private Capitulo capitulo;
    private Livro livro;

    public LivroController() {
        this.conteudo = new ArrayList<>();
        this.livro = new Livro();
        this.capitulo = new Capitulo();
    }

    public String continuar() {
        if (livro == null) {
            return null;
        }
        return "editor.xhtml";
    }

    public String addCapitulo(Capitulo capitulo) {
        if (capitulo == null) {
            return null;
        }
        conteudo.add(capitulo);
        this.capitulo = new Capitulo();
        return "editor.xhtml";
    }

    public List<Capitulo> tabelaDeConteudo() {
        return conteudo;
    }

    public String finalizarLivro() throws IOException {
        MarckupChain marckupChain = new MarckupChain();
        for (Capitulo texto : conteudo) {
            String paraHTML = marckupChain.paraHTML(texto.getConteudo());
            texto.setConteudo(paraHTML);
        }
        Epub epub = new Epub(livro.getTitulo() + "_" + livro.getNomeAutor(), "/home/vinicius/Vinicius/Netbeans/TCCGeradorEpub/src/main/webapp/resources/downloads/");
        epub.addAutor(livro.getNomeAutor(), livro.getSobrenomeAutor());
        epub.addEditora(livro.getEditora());
        epub.addTitulo(livro.getTitulo());
        epub.addCapitulos(conteudo);
        epub.processarConteudo();
        return "finalizado";
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Capitulo getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
    }

}
