package tcc.vinicius.mvc.controler;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tcc.vinicius.mvn.model.Livro;
@ManagedBean
@SessionScoped
public class LivroController implements Serializable{

    public String continuar(Livro livro) {
        if(livro.getTitulo() == null){
            return null;
        }
        if(livro.getTitulo().isEmpty()){
            return null;
        }
        return "editor.xhtml";
    }

    
    
    
}
