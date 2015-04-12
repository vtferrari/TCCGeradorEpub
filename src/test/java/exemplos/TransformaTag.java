package exemplos;

public class TransformaTag {

    public String paraHTML(String vinicius) {
        if (vinicius.contains("__")) {
            return vinicius.replaceAll("__", "<u>").replaceFirst("<u>$", "</u>");
        }
        return vinicius.replaceAll("\\*\\*", "<b>").replaceFirst("<b>$", "</b>");
    }

}
