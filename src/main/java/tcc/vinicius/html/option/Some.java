package tcc.vinicius.html.option;

public class Some<T> extends Option<T> {

    private T valorVerdadeiro = (T) valor;

    @Override
    public T get() {
        return valorVerdadeiro;
    }
}
