
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Refatora {

    public static float media(Float ... notas) {
        float soma = 0;

        for (Float nota : Arrays.asList(notas)) {
            soma += nota;
        }
        return soma / notas.length;
    }
    
    public static void main(String args[]) {
        System.out.println("nota1 = " + media(1f,2f,3f,3f));
        System.out.println("nota2 = " + media(7f,7f,7f));
    }

}
