package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    private User user;

    @BeforeEach
    void before() {
        List<Fraction> fractions= new ArrayList<>();
        user = new User("id", "Adrian", "Alonso", fractions);
    }

    @Test
    void testUser(){
        assertEquals(user.getId(), "id");
        assertEquals(user.getName(), "Adrian");
        assertEquals(user.getFamilyName(), "Alonso");
    }

    @Test
    void testEmptyUser(){
        user= new User();
        List<Fraction> fractions = user.getFractions();
        assertNotNull(fractions, "The fractions list should not be null");
        assertTrue(fractions.isEmpty(), "The fractions list should be empty");
    }

    @Test
    void testSetFractions(){
        Fraction fraction = new Fraction();
        List<Fraction> fractions= new ArrayList<>();
        fractions.add(fraction);
        user.setFractions(fractions);
        assertEquals(user.getFractions().size(), 1);
    }

    @Test
    void testAddFraction(){
        Fraction fraction = new Fraction();
        user.addFraction(fraction);
        assertEquals(user.getFractions().size(), 1);
    }

    @Test
    void testFullName(){
        assertEquals(user.fullName(), "Adrian Alonso");
    }

    @Test
    void testInitials(){
        assertEquals(user.initials(), "A.");
    }

    @Test
    void testSetNames(){
        user.setName("Alejandro");
        user.setFamilyName("Ledesma");
        assertEquals(user.getName(), "Alejandro");
        assertEquals(user.getFamilyName(), "Ledesma");
    }

    @Test
    void testToString(){
        String expected = "User{id='id', name='Adrian', familyName='Alonso', fractions=[]}";
        assertEquals(expected, user.toString());
    }

}