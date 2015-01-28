package tcc.vinicius.geradorepub.model;

import java.util.ArrayList;
import java.util.List;

public class Livro {

    private String titulo;
    private String nome;
    private String sobrenome;
    private String editora;
    private List<Capitulo> capitulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public List<Capitulo> getCapitulo() {
        if (capitulo == null) {
            capitulo = new ArrayList<>();
        }
        return capitulo;
    }

    public void setCapitulo(List<Capitulo> capitulo) {
        this.capitulo = capitulo;
    }

    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", nome=" + nome + ", sobrenome=" + sobrenome + ", editora=" + editora + ", capitulo=" + capitulo + '}';
    }

}
