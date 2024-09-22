package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SearchesTest {

    @Test
    void testFindUserNameBySomeImproperFraction(){
        assertEquals(List.of("Ana"), new Searches().findUserNameBySomeImproperFraction()
              .collect(Collectors.toList()));
    }

    @Test
    void testFindUserIdBySomeProperFraction(){
        assertEquals(List.of("2","3","5"), new Searches().findUserIdBySomeProperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFirstDecimalFractionByUserName(){
        assertEquals(2.0, new Searches().findFirstDecimalFractionByUserName("Ana"));
    }

    @Test
    void testFindFirstDecimalFractionByUserNameNull(){
        assertNull(new Searches().findFirstDecimalFractionByUserName("Pedro"));
    }
    @Test
    void testFindDecimalFractionByUserName(){
        assertEquals(List.of(1.0, 1.0, NaN, POSITIVE_INFINITY, 1.0), new Searches().findDecimalFractionByUserName("Paula")
                .collect(Collectors.toList()));
    }

}
