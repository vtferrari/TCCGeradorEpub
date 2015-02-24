package tcc.vinicius.mvc.controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tcc.vinicius.html.superlinguagem.MarckupChain;
import tcc.vinicius.mvn.model.Capitulo;
import tcc.vinicius.mvn.model.Livro;

@ManagedBean
@SessionScoped
public class LivroController implements Serializable {

    private final List<Capitulo> conteudo;

    public LivroController() {
        this.conteudo = new ArrayList<>();
    }

    public String continuar(Livro livro) {
        if (livro == null) {
            return null;
        }
        return "editor.xhtml";
    }

    public String addCapitulo(Capitulo capitulo) {
        if (capitulo != null) {
            conteudo.add(capitulo);
            return "editor.xhtml";
        }
        return null;
    }
    
    public List<Capitulo> tabelaDeConteudo() {
        return conteudo;
    }

    public String finalizarLivro() {
        MarckupChain marckupChain = new MarckupChain();
        for (Capitulo texto : conteudo) {
            String paraHTML = marckupChain.paraHTML(texto.getConteudo());
            texto.setConteudo(paraHTML);
        }
        return "finalizado";
    }

}
