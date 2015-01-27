package tcc.vinicius.html.busca.tag.simbolo;

public class TagColchetes implements BuscaTagSPL{
    
    private final String seletor;

    public TagColchetes(String seletor) {
        this.seletor = seletor;
    }
    
    @Override
    public String converteParaHTML(String html) {
        return html.replace("["+seletor+"]", "<"+seletor+">")
                   .replace("[/"+seletor+"]", "</"+seletor+">");
    }
    
}
