package tcc.vinicius.geradorepub.mb;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tcc.vinicius.geradorepub.model.Capitulo;
import tcc.vinicius.geradorepub.model.Livro;
import tcc.vinicius.html.superlinguagem.SuperLinguagemSimbolo;

@ManagedBean
@SessionScoped
public class Autoria {

    private Livro livro;
    private Capitulo capitulo;

    public Autoria() {
        this.livro = new Livro();
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Capitulo> getCapitulos() {
        return livro.getCapitulo();
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.livro.setCapitulo(capitulos);
    }

    public String continuar() {
        this.capitulo = new Capitulo();
        return "editor";
    }

    public String novoCapitulo() {
        this.livro.getCapitulo().add(this.capitulo);
        this.capitulo = new Capitulo();
        return "editor";
    }

    public Capitulo getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
    }

    public void publicarEpub() {
        EBook book = new EBook();
        book.setTitulo(this.livro.getTitulo());
        book.setNomeAutor(this.livro.getNome());
        book.setSobrenomeAutor(this.livro.getSobrenome());
        book.setEditora(this.livro.getEditora());

        for (Capitulo capituloLivro : this.livro.getCapitulo()) {
            book.addCapitulo(capituloLivro.getConteudo());
            capituloLivro.getTitulo();
        }
        book.publicar();
    }

    public String processar(String conteudo) {
        System.out.println(conteudo);
        System.out.println(new SuperLinguagemSimbolo().paraHTML(conteudo));
        return new SuperLinguagemSimbolo().paraHTML(conteudo);
    }

}
