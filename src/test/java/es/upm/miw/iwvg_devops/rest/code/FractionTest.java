package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void testIsProper(){
        assertFalse(fraction.isProper());
        fraction = new Fraction(2,4);
        assertTrue(fraction.isProper());
    }

    @Test
    void testIsImproper(){
        assertTrue(fraction.isImproper());
        fraction = new Fraction(2,4);
        assertFalse(fraction.isImproper());
    }

    @Test
    void testIsEquivalent(){
        Fraction equivalent = new Fraction(6,3);
        assertTrue(fraction.isEquivalent(equivalent));
    }

    @Test
    void testAdd(){
        Fraction addFraction = new Fraction(3,7);
        assertEquals(17,fraction.add(addFraction).getNumerator());
        assertEquals(7,fraction.add(addFraction).getDenominator());
        fraction.setNumerator(1);
        assertEquals(13,fraction.add(addFraction).getNumerator());
        assertEquals(14,fraction.add(addFraction).getDenominator());
    }

    @Test
    void testMultiply(){
        Fraction multiplyFraction = new Fraction(3,5);
        assertEquals(12,fraction.multiply(multiplyFraction).getNumerator());
        assertEquals(10,fraction.multiply(multiplyFraction).getDenominator());
    }

    @Test
    void testDivide(){
        Fraction divideFraction = new Fraction(3,6);
        assertEquals(24,fraction.divide(divideFraction).getNumerator());
        assertEquals(6,fraction.divide(divideFraction).getDenominator());
    }

    @Test
    void testToString(){
        String expected = "Fraction{numerator=4, denominator=2}";
        assertEquals(expected, fraction.toString());
    }
}
