package exemplos;

public class TransformaTag {

    public String paraHTML(String html, String de, String para) {

        return html
                .replaceAll(de, "<" + para + ">")
                .replaceFirst("<" + para + ">$", "</" + para + ">");

    }

}
