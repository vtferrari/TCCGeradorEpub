package tcc.vinicius.geradorepub.model;

import java.util.ArrayList;
import java.util.List;

public class Livro {

    private String titulo;
    private String Nome;
    private String Sobrenome;
    private String editora;
    private List<Capitulo> capitulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String Sobrenome) {
        this.Sobrenome = Sobrenome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public List<Capitulo> getCapitulo() {
        if(capitulo == null){
            capitulo = new ArrayList<>();
        }
        return capitulo;
    }

    public void setCapitulo(List<Capitulo> capitulo) {
        this.capitulo = capitulo;
    }

}
