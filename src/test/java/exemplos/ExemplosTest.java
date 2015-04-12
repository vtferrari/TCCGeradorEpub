package exemplos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExemplosTest {

    @Test
    public void transformaAsteriscoEmTagB() {
        TransformaTag transforma = new TransformaTag();
        assertEquals("<b>vinicius</b>", transforma.paraHTML("**vinicius**"));
    }

    @Test
    public void transformaUnderlineEmTagU() {
        TransformaTag transforma = new TransformaTag();
        assertEquals("<u>vinicius</u>", transforma.paraHTML("__vinicius__"));
    }

}
