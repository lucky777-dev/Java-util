import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mrsmile
 */
public class Exercice08Test {

    public Exercice08Test() {
    }

    /**
     * Test of pgcd method, of class Exercice08.
     */
    @Test
    public void testPgcdAEgalB() {
        System.out.println("pgcd");
        int a = 64;
        int b = 64;
        int expResult = 64;
        int result = Exercice08.pgcd(a, b);
        assertEquals(expResult, result);
    }

    @Test
    public void testPgcdBZero() {
        System.out.println("pgcd");
        int a = 12;
        int b = 0;
        assertThrows(IllegalArgumentException.class, () -> { Exercice08.pgcd(a, b); } );
    }
}