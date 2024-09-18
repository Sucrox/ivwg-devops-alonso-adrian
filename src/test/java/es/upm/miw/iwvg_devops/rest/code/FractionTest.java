package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {
   private Fraction fraction;

    @BeforeEach
    void before() {
    fraction = new Fraction(4,2);
    }

    @Test
    void testFraction() {
        assertEquals(4,fraction.getNumerator());
        assertEquals(2,fraction.getDenominator());
    }

    @Test
    void testEmptyFraction() {
        fraction= new Fraction();
        assertEquals(1,fraction.getNumerator());
        assertEquals(1,fraction.getDenominator());
    }

    @Test
    void testSetNumerator() {
        fraction.setNumerator(3);
        assertEquals(3,fraction.getNumerator());
    }

    @Test
    void testSetDenominator() {
        fraction.setDenominator(3);
        assertEquals(3,fraction.getDenominator());
    }

    @Test
    void testDecimal(){
        assertEquals(2.0,fraction.decimal());
    }



    @Test
    void testToString(){
        String expected = "Fraction{numerator=4, denominator=2}";
        assertEquals(expected, fraction.toString());
    }

}
