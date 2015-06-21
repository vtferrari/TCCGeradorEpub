package tcc.vinicius.mvc.controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tcc.vinicius.mvn.model.Livro;

@ManagedBean
@RequestScoped
public class FileDownloadView {

    private String link = "downloads/";

    public String getLink(Livro livro) {
        return link + livro.getTitulo() + "_" + livro.getNomeAutor() + ".epub";
    }

}
