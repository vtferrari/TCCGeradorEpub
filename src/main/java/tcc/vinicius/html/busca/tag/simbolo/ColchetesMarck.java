package tcc.vinicius.html.busca.tag.simbolo;

public class ColchetesMarck implements Marck{
    
    private final String seletor;

    public ColchetesMarck(String seletor) {
        this.seletor = seletor;
    }
    
    @Override
    public String converteParaHTML(String html) {
        return html.replace("["+seletor+"]", "<"+seletor+">")
                   .replace("[/"+seletor+"]", "</"+seletor+">");
    }
    
}
