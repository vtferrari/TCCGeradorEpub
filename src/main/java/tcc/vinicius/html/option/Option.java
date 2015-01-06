package tcc.vinicius.html.option;

import java.util.ArrayList;
import java.util.List;

public abstract class Option<T> {
    protected static Object valor;

    public abstract T get();

    public static <T> Option<T> of(T valor) {
        Option.valor = valor;
        if (valor == null) {
            return new None<>();
        }
        return new Some<>();
    }

    public Option<T> orElse(T valor) {
        if (valor != null) {
            of(valor);
            return new Some<>();
        }
        return new None<>();
    }

    public T getOrElse(T valor) {
        if (this instanceof None) {
            return valor;
        }
        return get();
    }

    public Option<T> filter(boolean verdadeiro) {
        if (verdadeiro) {
            return (Option<T>) of(valor);
        }
        return new None<>();
    }

    public Option<T> filterNot(boolean verdadeiro) {
        if (!verdadeiro) {
            return (Option<T>) of(valor);
        }
        return new None<>();
    }

    public T orNull() {
        if (valor == null) {
            return null;
        }
        return get();
    }

    public static <T> List<T> valuesOf(List<Option<T>> lista) {
        List<T> listaValores = new ArrayList<>();
        for (Option<T> option : lista) {
            if (option instanceof Some) {
                listaValores.add(option.get());
            }
        }
        return listaValores;
    }
}
